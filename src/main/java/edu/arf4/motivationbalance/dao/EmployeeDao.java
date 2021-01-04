package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmpById(Long id, boolean getProxy);
    List<Long> getAllEmpIds();
    List<Long> getSubordinatesIdsByManagerId(Long id);

}
