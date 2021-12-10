package de.chojo.jdautil.botlist.modules.voting.post.payload;

import de.chojo.jdautil.botlist.modules.voting.post.VoteData;

public class TopGg implements VoteDataAdapter {
    private long bot;
    private long user;
    private String type;
    private boolean isWeekend;

    @Override
    public VoteData toVotaData() {
        return new VoteData(user, isWeekend);
    }
}
