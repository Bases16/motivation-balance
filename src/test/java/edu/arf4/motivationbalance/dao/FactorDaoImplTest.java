package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.model.Factor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FactorDaoImplTest {

    @Autowired
    private FactorDao factorDao;

    @Test
    @Transactional
    public void getRelevantFactors() {

        List<Factor> relevantFactors = factorDao.getRelevantFactors();
        assertNotNull(relevantFactors);
        assertEquals(3, relevantFactors.size());
//        relevantFactors.forEach(f -> System.out.println(f.getName()));
    }

    @Test
    public void getFactorByName() {

        Factor factor = factorDao.getFactorByName("Scrum");
        assertNotNull(factor);
        assertEquals("Scrum", factor.getName());
        assertEquals("PP", factorDao.getFactorByName("PP").getName());
        assertEquals("Gym", factorDao.getFactorByName("Gym").getName());
        assertEquals("Free Coffee", factorDao.getFactorByName("Free Coffee").getName());


    }

}