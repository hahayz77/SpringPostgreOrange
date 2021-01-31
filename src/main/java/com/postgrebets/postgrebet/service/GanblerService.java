package com.postgrebets.postgrebet.service;

import com.postgrebets.postgrebet.model.Bet;
import com.postgrebets.postgrebet.model.Ganbler;
import com.postgrebets.postgrebet.repository.BetRepository;
import com.postgrebets.postgrebet.repository.GanblerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GanblerService {

    private final GanblerRepository ganblerRepository;

    private final BetRepository betRepository;

    @Autowired
    public GanblerService(GanblerRepository ganblerRepository, BetRepository betRepository) {
        this.ganblerRepository = ganblerRepository;
        this.betRepository = betRepository;
    }

    public List<Ganbler> findAll(){
        return ganblerRepository.findAll();
    }

    public Ganbler newGanbler(Ganbler ganbler){

        Optional<Ganbler> ganblerOptional = ganblerRepository
                .findGanblerByEmail(ganbler.getEmail());

        if(ganblerOptional.isPresent()){                        // TEM EMAIL
            //          throw new IllegalStateException("Email already in use!");

            Ganbler ganblerDB = ganblerOptional.get();
            Bet newBet = new Bet(new Date(), null);
            betRepository.save(newBet);

            if (ganblerDB.getBetList() == null){                // SE NÃO TEM APOSTA
                ganblerDB.setBetList(new ArrayList<Bet>());     // LIST VAZIA CRIADA
            }

            List<Bet> ganblerBets = ganblerDB.getBetList();     // PEGAR LISTA DO BANCO
            ganblerBets.add(newBet);                            //ADICIONAR APOSTA (BET) NA LISTA
            return ganblerRepository.save(ganblerDB);

        }

        return ganblerRepository.save(ganbler);
    }



}
