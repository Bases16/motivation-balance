package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.dto.EstimationPairDto;
import edu.arf4.motivationbalance.dto.ResultDto;
import edu.arf4.motivationbalance.model.EstimationPair;
import edu.arf4.motivationbalance.model.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ResultServiceTest {

    @Autowired
    private ResultService resultService;
    @Autowired
    private ResultDao resultDao;

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Test
    @Transactional
    public void saveResult() {
        ResultDto resultDto = new ResultDto();
        List<EstimationPairDto> estimationDtoPairs = new ArrayList<>();
        estimationDtoPairs.add(new EstimationPairDto("Scrum", "LIKE"));
        estimationDtoPairs.add(new EstimationPairDto("PP", "DISLIKE"));
        estimationDtoPairs.add(new EstimationPairDto("Gym", "NEUTRAL"));
        resultDto.setEstimationPairs(estimationDtoPairs);
        resultDto.setEmpId(1L);

        Long newResultId = resultService.saveResult(resultDto);
        em.flush();
        Result newResult = resultDao.getResultById(newResultId);

        assertEquals(resultDto.getEmpId(), newResult.getEmployee().getId());
        assertTrue(newResult.isRelevant());
        Set<EstimationPair> estimPairs = newResult.getEstimationPairs();
        assertEquals(3, estimPairs.size());
    }

    @Test
    public void getAllResultsByEmpId() {
        final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final Long EMP_ID = 3L;

        List<ResultDto> allResultsByEmpId = resultService.getAllResultsDtoByEmpId(EMP_ID);
        assertNotNull(allResultsByEmpId);
        assertEquals(2, allResultsByEmpId.size());

        ResultDto dto1 = allResultsByEmpId.get(0);
        assertEquals(EMP_ID, dto1.getEmpId());
        assertEquals("2019-12-20 12:00", dto1.getPassDatetime().format(DTF));
        List<EstimationPairDto> dto1Pairs = dto1.getEstimationPairs();
        assertEquals(4, dto1Pairs.size());
        assertTrue(dto1Pairs.contains(new EstimationPairDto("Scrum", "NEUTRAL")));
        assertTrue(dto1Pairs.contains(new EstimationPairDto("PP", "LIKE")));
        assertTrue(dto1Pairs.contains(new EstimationPairDto("Free Coffee", "LIKE")));
        assertTrue(dto1Pairs.contains(new EstimationPairDto("Gym", "DISLIKE")));

        ResultDto dto2 = allResultsByEmpId.get(1);
        assertEquals(EMP_ID, dto2.getEmpId());
        assertEquals("2020-12-20 14:00", dto2.getPassDatetime().format(DTF));
        List<EstimationPairDto> dto2Pairs = dto2.getEstimationPairs();
        assertEquals(3, dto2Pairs.size());
        assertTrue(dto2Pairs.contains(new EstimationPairDto("Scrum", "DISLIKE")));
        assertTrue(dto2Pairs.contains(new EstimationPairDto("PP", "NEUTRAL")));
        assertTrue(dto2Pairs.contains(new EstimationPairDto("Gym", "LIKE")));
    }

    @Test
    public void getAllRelevResultsDto() {
        List<ResultDto> dtos = resultService.getAllRelevResultsDto();
        assertNotNull(dtos);
        assertEquals(4, dtos.size());
    }

    @Test
    public void getAllRelevResultsDtoByManagerId() {
        List<ResultDto> dtos = resultService.getAllRelevResultsDtoByManagerId(1L);
        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        dtos = resultService.getAllRelevResultsDtoByManagerId(2L);
        assertNotNull(dtos);
        assertEquals(1, dtos.size());

    }


}
