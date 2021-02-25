package edu.arf4.motivationbalance.dto;

import java.util.Objects;

public class EstimationPairDto {
    private String factorName;
    private String estimation;

    public EstimationPairDto() {}
    public EstimationPairDto(String factorName, String estimationVal) {
        this.factorName = factorName;
        this.estimation = estimationVal;
    }

    public String getFactorName() { return factorName; }
    public String getEstimation() { return estimation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstimationPairDto that = (EstimationPairDto) o;
        return factorName.equals(that.factorName) && estimation.equals(that.estimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factorName, estimation);
    }
}
