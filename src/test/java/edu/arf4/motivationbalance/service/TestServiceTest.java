package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceTest {


    @Test
    @Transactional
    public void test() {
        System.out.println("HELLO FROM TEST");
    }

}