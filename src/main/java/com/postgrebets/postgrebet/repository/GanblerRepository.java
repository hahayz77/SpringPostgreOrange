package com.postgrebets.postgrebet.repository;


import com.postgrebets.postgrebet.model.Ganbler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GanblerRepository extends JpaRepository<Ganbler, Long> {

    public Optional<Ganbler> findGanblerByEmail(String email);


}
