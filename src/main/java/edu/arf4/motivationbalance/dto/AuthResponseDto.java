package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty
    private final Long empId;
    @JsonProperty
    private final String email;
    @JsonProperty
    private final String token;

    public AuthResponseDto(Long empId, String email, String token) {
        this.empId = empId;
        this.email = email;
        this.token = token;
    }
}
