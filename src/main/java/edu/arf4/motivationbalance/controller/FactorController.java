package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.FactorDto;
import edu.arf4.motivationbalance.service.FactorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/factors")
public class FactorController {
    private final FactorService factorService;

    public FactorController(FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping
    public List<FactorDto> getAllFactors() {
        return factorService.getAllFactors();
    }

    @PostMapping
    public void createNewFactor(@RequestBody String factorName) {
        factorService.createNewFactor(factorName);
    }

    @PutMapping("/change-status")
    public void changeFactorStatus(@RequestBody String factorName) {
        factorService.changeFactorStatus(factorName);
    }

    @GetMapping("/active")
    public List<String> getActiveFactors() {
        return factorService.getActiveFactorNames();
    }

}
