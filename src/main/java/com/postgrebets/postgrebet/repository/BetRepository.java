package com.postgrebets.postgrebet.repository;

import com.postgrebets.postgrebet.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

    //   select n1,n2,n3 from bets where n1=96 and n2=65 and n3=55;

    @Query(value = "SELECT * FROM BETS WHERE n1 = ?1 AND n2 = ?2 AND n3 = ?3", nativeQuery = true)
    Bet findThatBet(int n1, int n2, int n3);

    
}
