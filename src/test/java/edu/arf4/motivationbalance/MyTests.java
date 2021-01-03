package edu.arf4.motivationbalance;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTests {

    @Autowired
    private TestDao testDao;

//    @Test
    public void shit() {
        Map<?, ?> estimationsByResultId = testDao.getEstimationsByResultId(4L);
        int x = 4;
    }
    @Test
    public void shit2() {
        List<Long> estimationsByResultId = testDao.getEmployeeIds(4L);
        int x = 4;
    }
}
