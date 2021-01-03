package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.arf4.motivationbalance.dto.converters.LocalDateTimeStringConverter;
import edu.arf4.motivationbalance.dto.converters.StringLocalDateTimeConverter;

import java.time.LocalDateTime;
import java.util.Map;

public class ResultDto {

    private Long employeeId;
    @JsonSerialize(converter = LocalDateTimeStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateTimeConverter.class) // todo  do i even need it ??
    private LocalDateTime passingDatetime;

    @JsonProperty("estimations")
    private Map<String, String> factorNameToEstimMap;



    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public void setPassingDatetime(LocalDateTime passingDatetime) {
        this.passingDatetime = passingDatetime;
    }
    public void setFactorNameToEstimMap(Map<String, String> factorNameToEstimMap) {
        this.factorNameToEstimMap = factorNameToEstimMap;
    }
    public LocalDateTime getPassingDatetime() {
        return passingDatetime;
    }
    public Map<String, String> getFactorNameToEstimMap() {
        return factorNameToEstimMap;
    }
}
