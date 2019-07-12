package ch.helsana.ix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.helsana.ix.entity.BusinessUnitVote;
import ch.helsana.ix.entity.Vote;
import ch.helsana.ix.service.VoteService;
// TODO Use RepositoryRestResource on Repository and get rid of controller
@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;

    @CrossOrigin
    @PostMapping("/votes")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vote createVote(@RequestBody Vote newVote) {
        return voteService.createVote(newVote);
    }

    @CrossOrigin
    @GetMapping("/votes")
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<BusinessUnitVote> getAvgVotesPerBusinessUnit() {
        return voteService.getAvgVotesPerBusinessUnit();
    }
}