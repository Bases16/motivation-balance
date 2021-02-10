package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty
    private String email;
    @JsonProperty
    private String token;

    public AuthResponseDto(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
