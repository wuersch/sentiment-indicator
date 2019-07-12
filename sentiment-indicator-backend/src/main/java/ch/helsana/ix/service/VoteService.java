package ch.helsana.ix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.helsana.ix.entity.BusinessUnitVote;
import ch.helsana.ix.entity.Vote;
import ch.helsana.ix.repository.VoteRepository;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public Iterable<BusinessUnitVote> getAvgVotesPerBusinessUnit() {
        return voteRepository.findAvgVotesPerBusinessUnit();
    }

    public Vote createVote(Vote newVote) {
        Vote savedVote;

        Vote previousVote = voteRepository.findPreviousVoteForUser(newVote.getUser());
        if(previousVote == null) {
            savedVote = voteRepository.save(newVote);
        } else {
            previousVote.setItem(newVote.getItem());
            savedVote = voteRepository.save(previousVote);
        }
        
        return savedVote;
    }
}