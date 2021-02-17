package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.service.FactorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/factors")
public class FactorController {

    private FactorService factorService;

    public FactorController(FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping
    public List<String> getActiveFactorNames() {
        return factorService.getActiveFactorNames();
    }

}
