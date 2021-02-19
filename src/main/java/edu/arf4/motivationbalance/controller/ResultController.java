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
@RequestMapping("/rest/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/save")
    public void saveResult(@RequestBody ResultDto resultDto) {
        resultService.saveResult(resultDto);
    }

    @GetMapping("/emp/{id}")
    public List<ResultDto> getAllResultsByEmpId(@PathVariable("id") Long empId) {
//        if (empId % 2 == 0) throw new RuntimeException();
        return resultService.getAllResultsDtoByEmpId(empId);
    }

    @GetMapping("/by-manager/{id}")
    public List<ResultDto> getAllRelevResultsByManagerId(@PathVariable("id") Long managerId) {
        return resultService.getAllRelevResultsDtoByManagerId(managerId);
    }


}
