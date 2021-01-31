package com.postgrebets.postgrebet.repository;


import com.postgrebets.postgrebet.model.Ganbler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GanblerRepository extends JpaRepository<Ganbler, Long> {

    // SELECT * FROM ganbler where email = ?
    // @Query("SELECT s FROM s where s.email = ?1")
    public Optional<Ganbler> findGanblerByEmail(String email);


}
