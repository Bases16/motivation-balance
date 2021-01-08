package edu.arf4.motivationbalance.dto;

public class AuthResponseDto {
    private String username;
    private String token;

    public AuthResponseDto(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
