package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
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
public class FactorServiceTest {

    @Autowired
    FactorService factorService;

    @Test
    @Transactional
    public void allSimpleFunctions() {

        List<String> allFactorNames = factorService.getAllFactorNames();
        assertNotNull(allFactorNames);
        assertEquals(4, allFactorNames.size());

        List<String> activeFactorNames = factorService.getActiveFactorNames();
        assertNotNull(activeFactorNames);
        assertEquals(3, activeFactorNames.size());

        String NEW_FACTOR_NAME = "NEW FACTOR";
        factorService.createNewFactor(NEW_FACTOR_NAME);

        allFactorNames = factorService.getAllFactorNames();
        assertEquals(5, allFactorNames.size());

        activeFactorNames = factorService.getActiveFactorNames();
        assertEquals(4, activeFactorNames.size());

        factorService.changeFactorStatus(NEW_FACTOR_NAME);

        allFactorNames = factorService.getAllFactorNames();
        assertEquals(5, allFactorNames.size());

        activeFactorNames = factorService.getActiveFactorNames();
        assertEquals(3, activeFactorNames.size());
    }

}