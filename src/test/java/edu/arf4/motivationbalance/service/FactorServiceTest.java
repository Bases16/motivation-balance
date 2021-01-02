package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dao.FactorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FactorServiceTest {

    @Autowired
    private FactorService factorService;
    @Autowired
    private FactorDao factorDao;


}