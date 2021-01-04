package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.model.Factor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FactorDaoImplTest {

    @Autowired
    private FactorDao factorDao;

    @Test
    public void getActiveFactors() {
        List<Factor> activeFactors = factorDao.getActiveFactors();
        assertNotNull(activeFactors);
        assertEquals(3, activeFactors.size());
    }

    @Test
    public void getFactorByName() {
        assertEquals("Scrum", factorDao.getFactorByName("Scrum").getName());
        assertEquals("PP", factorDao.getFactorByName("PP").getName());
        assertEquals("Gym", factorDao.getFactorByName("Gym").getName());
        assertEquals("Free Coffee", factorDao.getFactorByName("Free Coffee").getName());
    }

}