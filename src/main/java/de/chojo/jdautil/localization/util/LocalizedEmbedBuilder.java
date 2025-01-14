/*
 *     SPDX-License-Identifier: AGPL-3.0-only
 *
 *     Copyright (C) 2022 RainbowDashLabs and Contributor
 */

package de.chojo.jdautil.localization.util;

import de.chojo.jdautil.localization.ContextLocalizer;
import de.chojo.jdautil.localization.ILocalizer;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.Color;
import java.time.temporal.TemporalAccessor;

/**
 * Wrapper for auto localization of embeds.
 */
public class LocalizedEmbedBuilder extends EmbedBuilder {
    private final ContextLocalizer localizer;

    /**
     * Creates a new localized embed builder.
     *
     * @param event message context for guild and language detection
     */
    public LocalizedEmbedBuilder(ILocalizer localizer, CommandInteraction event) {
        this.localizer = localizer.getContextLocalizer(event == null ? null : event.getGuild());
    }

    public LocalizedEmbedBuilder(ContextLocalizer localizer) {
        this.localizer = localizer;
    }

    public LocalizedEmbedBuilder(ILocalizer localizer, @Nullable Guild guild) {
        this.localizer = localizer.getContextLocalizer(guild);
    }

    private String localize(String message) {
        return localizer.localize(message);
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder addField(@Nullable String name, @Nullable String value, boolean inline) {
        super.addField(localize(name), localize(value), inline);
        return this;
    }

    @Nonnull
    @Override
    @Deprecated
    public LocalizedEmbedBuilder addField(@Nullable MessageEmbed.Field field) {
        super.addField(field);
        return this;
    }

    /**
     * Add a localized field.
     *
     * @param field localized field to add.
     * @return the builder after the field has been set
     */
    public LocalizedEmbedBuilder addField(LocalizedField field) {
        return addField(field.getField());
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setTitle(@Nullable String title) {
        super.setTitle(localize(title));
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setTitle(@Nullable String title, @Nullable String url) {
        super.setTitle(localize(title), url);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setFooter(@Nullable String text) {
        super.setFooter(localize(text));
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setFooter(@Nullable String text, @Nullable String iconUrl) {
        super.setFooter(localize(text), iconUrl);
        return this;
    }

    /**
     * Set the description with auto translation.
     *
     * @param text text to set
     * @return the builder after the description has been set
     */
    public LocalizedEmbedBuilder setDescription(String text) {
        super.setDescription(localize(text));
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder appendDescription(@Nonnull CharSequence description) {
        super.appendDescription(localize(description.toString()));
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder clear() {
        super.clear();
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setTimestamp(@Nullable TemporalAccessor temporal) {
        super.setTimestamp(temporal);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setColor(@Nullable Color color) {
        super.setColor(color);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setColor(int color) {
        super.setColor(color);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setThumbnail(@Nullable String url) {
        super.setThumbnail(url);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setImage(@Nullable String url) {
        super.setImage(url);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setAuthor(@Nullable String name) {
        super.setAuthor(localize(name));
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setAuthor(@Nullable String name, @Nullable String url) {
        super.setAuthor(localize(name), url);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder setAuthor(@Nullable String name, @Nullable String url, @Nullable String iconUrl) {
        super.setAuthor(localize(name), url, iconUrl);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder addBlankField(boolean inline) {
        super.addBlankField(inline);
        return this;
    }

    @Nonnull
    @Override
    public LocalizedEmbedBuilder clearFields() {
        super.clearFields();
        return this;
    }
}
