package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.EstimationPairDto;
import edu.arf4.motivationbalance.service.EstimationPairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/estim-pairs")
public class StatsController {
    private final EstimationPairService estimationPairService;

    public StatsController(EstimationPairService estimationPairService) {
        this.estimationPairService = estimationPairService;
    }

    @GetMapping("/relevant")
    public List<EstimationPairDto> getAllRelevEstimationPairs() {
        return estimationPairService.getRelevEstimDtoPairsByAllActiveFactors();
    }

}
