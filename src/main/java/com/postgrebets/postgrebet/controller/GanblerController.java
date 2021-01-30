package com.postgrebets.postgrebet.controller;

import com.postgrebets.postgrebet.model.Ganbler;
import com.postgrebets.postgrebet.service.GanblerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GanblerController {

    private final GanblerService ganblerService;

    @Autowired
    public GanblerController(GanblerService ganblerService) {
        this.ganblerService = ganblerService;
    }

    @GetMapping
    public List<Ganbler> getGanblers(){
        return ganblerService.findAll();
    }

    @PostMapping
    public void newGanbler(@RequestBody Ganbler ganbler) {
        ganblerService.newGanbler(ganbler);
    }


}
