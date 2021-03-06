package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.config.DatabaseConfig;
import edu.arf4.motivationbalance.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = DatabaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoImplTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void getSubordinatesIdsByManagerId() {
        List<Long> subordinatesIds = employeeDao.getSubordinatesIdsByManagerId(2L);
        assertNotNull(subordinatesIds);
        assertEquals(2, subordinatesIds.size());
    }

    @Test
    public void getAllEmpIds() {
        List<Long> allEmpIds = employeeDao.getAllEmpIds();
        assertNotNull(allEmpIds);
        assertEquals(7, allEmpIds.size());
    }

    @Test
    public void getAllManagers() {
        List<Employee> managers = employeeDao.getAllManagers();
        assertNotNull(managers);
        assertEquals(2, managers.size());
    }
}
