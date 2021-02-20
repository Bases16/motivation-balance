package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactorDto {
    @JsonProperty
    private String name;
    @JsonProperty
    private String status;

    public FactorDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public FactorDto() {
    }
}
