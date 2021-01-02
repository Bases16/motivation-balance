package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Employee;

public interface EmployeeDao {
    Employee getEmployeeById(Long id, boolean getProxy);
}
