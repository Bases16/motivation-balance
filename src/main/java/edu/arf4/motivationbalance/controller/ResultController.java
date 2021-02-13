package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.service.ResultService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "authorization")
@RestController
@RequestMapping("/rest/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

//    @GetMapping("/{id}")
//    public List<ResultDto> getAllResultDtoByEmpId(@PathVariable("id") Long empId) {
//        return resultService.getAllResultsDtoByEmpId(empId);
//    }

    @GetMapping("/3")
    public List<ResultDto> getAllResultDtoByEmpId() {
        return resultService.getAllResultsDtoByEmpId(3L);
    }
}
