package com.postgrebets.postgrebet.controller;

import com.postgrebets.postgrebet.model.Bet;
import com.postgrebets.postgrebet.model.Ganbler;
import com.postgrebets.postgrebet.service.GanblerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GanblerController {

    private final GanblerService ganblerService;

    @Autowired
    public GanblerController(GanblerService ganblerService) {
        this.ganblerService = ganblerService;
    }

    @GetMapping("/")
    public List<Ganbler> getGanblers() {
        return ganblerService.findAll();
    }

    @PostMapping("/ganble/{email}")
    public Bet newBet(@NotNull @RequestBody Ganbler ganbler) {
        return ganblerService.newBet(ganbler);
    }

    @GetMapping("/bets/{email}")
    public List<Bet> findAllBets(@NotNull @RequestParam String email){
        return ganblerService.findAllBets(email);
    }

}

