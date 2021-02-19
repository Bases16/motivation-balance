package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.EmployeeDto;
import edu.arf4.motivationbalance.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/emps")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/by-manager/{id}")
    public List<EmployeeDto> getEmployeesByManagerId(@PathVariable("id") Long managerId) {
        return employeeService.getEmployeesDtoByManagerId(managerId);
    }
}
