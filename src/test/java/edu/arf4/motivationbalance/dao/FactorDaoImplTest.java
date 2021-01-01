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

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FactorDaoImplTest {

    @Autowired
    private FactorDao factorDao;

    @Test
    @Transactional
    public void getActiveFactors() {

        List<Factor> factors = factorDao.getRelevantFactors();

        factors.forEach(f -> System.out.println(f.getName()));

    }
}