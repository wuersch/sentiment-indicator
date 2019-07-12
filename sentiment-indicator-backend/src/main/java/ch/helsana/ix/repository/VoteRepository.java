package ch.helsana.ix.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.helsana.ix.entity.BusinessUnitVote;
import ch.helsana.ix.entity.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote,Long> {
    @Query(value = "SELECT new ch.helsana.ix.entity.BusinessUnitVote(v.businessUnit, AVG(v.item)) " +
                   "FROM Vote v " +
                   "WHERE year(v.timeOfVoting) = year(current_date) AND month(v.timeOfVoting) = month(current_date) " +
                   "GROUP BY v.businessUnit")
    Iterable<BusinessUnitVote> findAvgVotesPerBusinessUnit();

    @Query(value = "FROM Vote v WHERE user = ?1 AND year(v.timeOfVoting) = year(current_date) AND month(v.timeOfVoting) = month(current_date)")
    Vote findPreviousVoteForUser(String user);
}