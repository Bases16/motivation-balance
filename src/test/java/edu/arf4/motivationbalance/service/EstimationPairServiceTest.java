package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dto.EstimationPairDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EstimationPairServiceTest {

    @Autowired
    private EstimationPairService estimationPairService;

    @Test
    public void getRelevEstimDtoPairsByFactorName() {
        List<EstimationPairDto> pairsDto = estimationPairService.getRelevEstimDtoPairsByFactorName("PP");
        assertNotNull(pairsDto);
        assertEquals(4, pairsDto.size());

        pairsDto = estimationPairService.getRelevEstimDtoPairsByFactorName("Free Coffee");
        assertNotNull(pairsDto);
        assertEquals(0, pairsDto.size());
    }
}