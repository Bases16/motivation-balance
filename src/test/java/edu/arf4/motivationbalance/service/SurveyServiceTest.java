package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dto.ResultDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SurveyServiceTest {

    @Autowired
    private SurveyService surveyService;

    @Test
//    @Transactional
    public void saveResult() {
        ResultDto resultDto = new ResultDto();
        Map<String, String> factorNameToEstimMap = new HashMap<>();
        factorNameToEstimMap.put("Scrum", "LIKE");
        factorNameToEstimMap.put("PP", "NOT_LIKE");
        factorNameToEstimMap.put("Gym", "NEUTRAL");

        resultDto.setFactorNameToEstimMap(factorNameToEstimMap);
        resultDto.setEmployeeId(1L);
        Long newResultId = surveyService.saveResult(resultDto);
    }

    @Test
    public void getAllResultsByEmpId() {

        List<ResultDto> allResultsByEmpId = surveyService.getAllResultsByEmpId(3L);

        int x = 4;

    }
}