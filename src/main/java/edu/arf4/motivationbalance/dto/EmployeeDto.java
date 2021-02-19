package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {
    private Long id;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
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
