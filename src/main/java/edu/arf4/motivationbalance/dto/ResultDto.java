package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.arf4.motivationbalance.dto.converters.LocalDateTimeStringConverter;
import edu.arf4.motivationbalance.dto.converters.StringLocalDateTimeConverter;

import java.time.LocalDateTime;
import java.util.List;

public class ResultDto {

    private Long employeeId;
    @JsonSerialize(converter = LocalDateTimeStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateTimeConverter.class) // todo  do i even need it ??
    private LocalDateTime passingDatetime;
    private List<EstimationPairDto> estimationDtoPairs;


    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public void setPassingDatetime(LocalDateTime passingDatetime) {
        this.passingDatetime = passingDatetime;
    }
    public LocalDateTime getPassingDatetime() {
        return passingDatetime;
    }

    public List<EstimationPairDto> getEstimationDtoPairs() {
        return estimationDtoPairs;
    }
    public void setEstimationDtoPairs(List<EstimationPairDto> estimationDtoPairs) {
        this.estimationDtoPairs = estimationDtoPairs;
    }
}
