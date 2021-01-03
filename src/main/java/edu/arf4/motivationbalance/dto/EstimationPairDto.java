package edu.arf4.motivationbalance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.arf4.motivationbalance.model.Factor;
import edu.arf4.motivationbalance.model.enums.Estimation;

public class EstimationPairDto {

    @JsonProperty
    private Factor factor;

    @JsonProperty
    private Estimation estimation;



    public Factor getFactor() {
        return factor;
    }
    public void setFactor(Factor factor) {
        this.factor = factor;
    }
    public Estimation getEstimation() {
        return estimation;
    }
    public void setEstimation(Estimation estimation) {
        this.estimation = estimation;
    }
}
