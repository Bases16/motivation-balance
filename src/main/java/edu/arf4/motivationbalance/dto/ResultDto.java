package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.arf4.motivationbalance.dto.converters.LocalDateTimeStringConverter;
import edu.arf4.motivationbalance.dto.converters.StringLocalDateTimeConverter;

import java.time.LocalDateTime;
import java.util.List;

public class ResultDto {
    private Long empId;
    @JsonSerialize(converter = LocalDateTimeStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateTimeConverter.class)
    private LocalDateTime passDatetime;
    private List<EstimationPairDto> estimationPairs;

    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public LocalDateTime getPassDatetime() {
        return passDatetime;
    }
    public void setPassDatetime(LocalDateTime passDatetime) {
        this.passDatetime = passDatetime;
    }
    public List<EstimationPairDto> getEstimationPairs() {
        return estimationPairs;
    }
    public void setEstimationPairs(List<EstimationPairDto> estimationPairs) {
        this.estimationPairs = estimationPairs;
    }
}
