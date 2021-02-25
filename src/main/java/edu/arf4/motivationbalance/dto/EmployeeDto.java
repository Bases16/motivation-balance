package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {
    private Long id;
    @JsonProperty
    private Long managerId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String empRole;

    public EmployeeDto(Long id, Long managerId, String firstName, String lastName, String empRole) {
        this.id = id;
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empRole = empRole;
    }

    public Long getId() {
        return id;
    }

}
