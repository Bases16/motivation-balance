package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.model.Factor;
import edu.arf4.motivationbalance.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SurveyServiceTest {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private ResultDao resultDao;


    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;
    @Autowired
    JtaTransactionManager txManager;

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
        em.flush();
        Result newResult = resultDao.getResultById(newResultId);

        assertEquals(resultDto.getEmployeeId(), newResult.getEmployee().getId());
        assertEquals(resultDto.getPassingDatetime(), newResult.getPassingDatetime());
//        assertEquals(resultDto.get(), newResult.getEmployee().getId());



    }



    @Test
    public void getAllResultsByEmpId() {
        List<ResultDto> allResultsByEmpId = surveyService.getAllResultsDtoByEmpId(3L);
        int x = 4;
    }

}