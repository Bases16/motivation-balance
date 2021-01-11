package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty
    private String username;
    @JsonProperty
    private String token;

    public AuthResponseDto(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
