package com.postgrebets.postgrebet.service;

import com.postgrebets.postgrebet.model.Bet;
import com.postgrebets.postgrebet.model.Ganbler;
import com.postgrebets.postgrebet.repository.BetRepository;
import com.postgrebets.postgrebet.repository.GanblerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Bet newBet(Ganbler ganbler){

        Optional<Ganbler> ganblerOptional = ganblerRepository
                .findGanblerByEmail(ganbler.getEmail());

        if(ganblerOptional.isPresent()){                         // TEM EMAIL
            //          throw new IllegalStateException("Email already in use!");

            Ganbler ganblerDB = ganblerOptional.get();          // PASSAR OPTIONAL PARA GANBLER

            // GERAR NUMEROS
            Random randomNumbers = new Random();
            int[] randomResult = new int[3];

            for (int i = 0; i <=2; i++){
                int num = randomNumbers.nextInt(99);
                randomResult[i] = num;
            }


            Bet newBet = new Bet(randomResult[0], randomResult[1], randomResult[2], new Date());   // NEW BET
            betRepository.save(newBet);                         // SAVE BET

            if (ganblerDB.getBetList() == null){                // SE NÃO TEM APOSTA
                ganblerDB.setBetList(new ArrayList<Bet>());     // LIST VAZIA CRIADA
            }

            ganblerDB.getBetList().add(newBet);                 // PEGAR LISTA DO BANCO E ADICIONAR APOSTA
            ganblerRepository.save(ganblerDB);                  // SALVAR NO REPOSITORIO
            return newBet;

        }
        else{                                                   //NÃO TEM EMAIL
            ganblerRepository.save(ganbler);                    // SALVAR NO REPOSITORIO
            Optional<Ganbler> findGanblerDB = ganblerRepository
                    .findGanblerByEmail(ganbler.getEmail());
            Ganbler ganblerDB = findGanblerDB.get();

            Bet testBet;
            Bet newBet;
            do {
                // GERAR NUMEROS - 2
                Random randomNumbers = new Random();
                int[] randomResult = new int[3];
                for (int i = 0; i <=2; i++){
                    int num = randomNumbers.nextInt(99);
                    randomResult[i] = num;
                }
                //TESTAR VALORES DA APOSTA
                newBet = new Bet(randomResult[0], randomResult[1], randomResult[2], new Date());
                testBet = betRepository.findThatBet(randomResult[0], randomResult[1], randomResult[2]);

            }while (testBet != null);

            betRepository.save(newBet);

            ganblerDB.setBetList(new ArrayList<Bet>());         // LIST VAZIA CRIADA
            ganblerDB.getBetList().add(newBet);                 // PEGAR LISTA DO BANCO E ADICIONAR APOSTA
            ganblerRepository.save(ganblerDB);
            return newBet;
        }
    }

    public List<Bet> findAllBets(String email) {
        Optional<Ganbler> ganblerOptional = ganblerRepository
                .findGanblerByEmail(email);

        return ganblerOptional.get().getBetList();
    }
}
