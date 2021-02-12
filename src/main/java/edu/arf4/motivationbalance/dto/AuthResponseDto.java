package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String email;
    @JsonProperty
    private String token;

    public AuthResponseDto(Long id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }
}
