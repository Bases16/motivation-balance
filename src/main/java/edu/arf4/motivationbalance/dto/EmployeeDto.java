package edu.arf4.motivationbalance.dto;

public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String empRole;

    public EmployeeDto(Long id, String firstName, String lastName, String empRole) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empRole = empRole;
    }

    public Long getId() {
        return id;
    }


}
