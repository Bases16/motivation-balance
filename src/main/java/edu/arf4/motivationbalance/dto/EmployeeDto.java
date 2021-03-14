package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {
    @JsonProperty
    private final Long id;
    @JsonProperty
    private final Long managerId;
    @JsonProperty
    private final String firstName;
    @JsonProperty
    private final String lastName;
    @JsonProperty
    private final String empRole;

    public EmployeeDto(Long id, Long managerId, String firstName, String lastName, String empRole) {
        this.id = id;
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empRole = empRole;
    }

}
