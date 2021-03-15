package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.arf4.motivationbalance.dto.converters.OffsetDateTimeStringConverter;
import edu.arf4.motivationbalance.dto.converters.StringOffsetDateTimeConverter;

import java.time.OffsetDateTime;
import java.util.List;

public class ResultDto {
    private Long empId;
    @JsonSerialize(converter = OffsetDateTimeStringConverter.class)
    @JsonDeserialize(converter = StringOffsetDateTimeConverter.class)
    private OffsetDateTime passDatetime;
    private List<EstimationPairDto> estimationPairs;

    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public OffsetDateTime getPassDatetime() {
        return passDatetime;
    }
    public void setPassDatetime(OffsetDateTime passDatetime) {
        this.passDatetime = passDatetime;
    }
    public List<EstimationPairDto> getEstimationPairs() {
        return estimationPairs;
    }
    public void setEstimationPairs(List<EstimationPairDto> estimationPairs) {
        this.estimationPairs = estimationPairs;
    }
}
