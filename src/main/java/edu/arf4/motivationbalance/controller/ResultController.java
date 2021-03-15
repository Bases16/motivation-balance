package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/results")
    public void saveResult(@RequestBody ResultDto resultDto) {
        resultService.saveResult(resultDto);
    }

    @GetMapping("/emps/{id}/results")
    public List<ResultDto> getAllResultsByEmpId(@PathVariable("id") Long empId) {
        return resultService.getAllResultsDtoByEmpId(empId);
    }

    @GetMapping("/emps/by-manager/{id}/results/relevant")
    public List<ResultDto> getAllRelevResultsByManagerId(@PathVariable("id") Long managerId) {
        return resultService.getAllRelevResultsDtoByManagerId(managerId);
    }

}
