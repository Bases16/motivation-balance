package edu.arf4.motivationbalance.controller;

import edu.arf4.motivationbalance.dto.EmployeeDto;
import edu.arf4.motivationbalance.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/rest/emps")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/search-employee")
    public List<EmployeeDto> getEmployeesByManagerId
            (@QueryParam("first") String first, @QueryParam("second") String second) {
        return employeeService.searchEmployeesByName(first, second);
    }

    @GetMapping("/by-manager/{id}")
    public List<EmployeeDto> getEmployeesByManagerId(@PathVariable("id") Long managerId) {
        return employeeService.getEmployeesDtoByManagerId(managerId);
    }

    @GetMapping("/managers")
    public List<EmployeeDto> getAllManagers() {
        return employeeService.getAllManagersDto();
    }

    @GetMapping("/emps-without-managers")
    public List<EmployeeDto> getEmployeesWithoutManagers() {
        return employeeService.getEmployeesDtoWithoutManagers();
    }

    @PostMapping("/change-role")
    public void changeEmployeeRole(@RequestBody Long empId) {
        employeeService.changeEmployeeRole(empId);
    }

    @PostMapping("/remove")
    public void removeEmployee(@RequestBody Long empId) {
        employeeService.removeEmployee(empId);
    }

    @PostMapping("/release-from-manager")
    public void releaseFromManager(@RequestBody Long empId) {
        employeeService.releaseFromManager(empId);
    }

    @PostMapping("/assign-manager/{managerId}")
    public void releaseFromManager(@RequestBody Long empId, @PathVariable("managerId") Long managerId) {
        employeeService.assignManager(empId, managerId);
    }

}
