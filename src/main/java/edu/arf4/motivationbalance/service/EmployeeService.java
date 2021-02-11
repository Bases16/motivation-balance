package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.dto.EmployeeDto;
import edu.arf4.motivationbalance.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(readOnly = true)
    List<EmployeeDto> getEmployeesDtoByManagerId(Long managerId) {

        Employee manager = employeeDao.getEmpById(managerId, false);
        Set<Employee> subordinates = manager.getSubordinates();



        return null;
    }


}