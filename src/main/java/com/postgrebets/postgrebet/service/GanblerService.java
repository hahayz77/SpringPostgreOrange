package com.postgrebets.postgrebet.service;

import com.postgrebets.postgrebet.model.Ganbler;
import com.postgrebets.postgrebet.repository.GanblerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GanblerService {

    private final GanblerRepository ganblerRepository;

    @Autowired
    public GanblerService(GanblerRepository ganblerRepository) {
        this.ganblerRepository = ganblerRepository;
    }

    public List<Ganbler> findAll(){
        return ganblerRepository.findAll();
    }

    public void newGanbler(Ganbler ganbler){
        Optional<Ganbler> ganblerOptional = ganblerRepository
                .findGanblerByEmail(ganbler.getEmail());
        if(ganblerOptional.isPresent()){
            throw new IllegalStateException("Email already in use!");
        }
        ganblerRepository.save(ganbler);
    }
}
