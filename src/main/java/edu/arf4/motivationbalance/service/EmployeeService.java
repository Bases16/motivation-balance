package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.dto.EmployeeDto;
import edu.arf4.motivationbalance.model.Employee;
import edu.arf4.motivationbalance.model.User;
import edu.arf4.motivationbalance.model.enums.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final UserDao userDao;

    public EmployeeService(EmployeeDao employeeDao, UserDao userDao) {
        this.employeeDao = employeeDao;
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getEmployeesDtoByManagerId(Long managerId) {
        Employee manager = employeeDao.getEmpById(managerId, false);
        Set<Employee> subordinates = manager.getSubordinates();

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        subordinates.forEach(emp -> employeeDtos
                .add(new EmployeeDto(emp.getId(), managerId, emp.getFirstName(), emp.getLastName(),
                                     emp.getEmpRole().name() )
        ));
        return employeeDtos;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllManagersDto() {
        List<Employee> managers = employeeDao.getAllManagers();
        List<EmployeeDto> managerDtos = new ArrayList<>();
        managers.forEach(emp -> {
            Long managerId = emp.getManager() != null ? emp.getManager().getId() : null;
            managerDtos.add(new EmployeeDto(emp.getId(), managerId, emp.getFirstName(),
                                            emp.getLastName(), emp.getEmpRole().name() ));
        });
        return managerDtos;
    }

    @Transactional
    public void changeEmployeeRole(Long empId) {
        Employee emp = employeeDao.getEmpById(empId, false);
        User user = userDao.getUserByEmpId(empId);
        emp.setManager(null);
        if (emp.getEmpRole() == Role.MANAGER) {
            emp.getSubordinates().forEach(sub -> releaseFromManager(sub.getId()));
            emp.setEmpRole(Role.SPECIALIST);
            user.setRole(Role.SPECIALIST);
        } else {
            emp.setEmpRole(Role.MANAGER);
            user.setRole(Role.MANAGER);
        }
    }

    @Transactional
    public void removeEmployee(Long empId) {
        Employee emp = employeeDao.getEmpById(empId, false);
        emp.getSubordinates().forEach(sub -> releaseFromManager(sub.getId()));
        employeeDao.removeEmployee(emp);
    }

    @Transactional
    public void releaseFromManager(Long empId) {
        Employee emp = employeeDao.getEmpById(empId, false);
        emp.setManager(null);
    }

    @Transactional
    public void assignManager(Long empId, Long managerId) {
        Employee emp = employeeDao.getEmpById(empId, false);
        Employee manager = employeeDao.getEmpById(managerId, true);
        emp.setManager(manager);
    }

}
