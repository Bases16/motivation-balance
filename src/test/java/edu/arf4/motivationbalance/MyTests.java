package edu.arf4.motivationbalance;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTests {

    @Autowired
    private TestDao testDao;

    @Test
    public void test() {

    }
}
