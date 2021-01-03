package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.Estimation;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estimation_pairs")
public class EstimationPair {

    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(updatable = false)
    private Result result;
    @ManyToOne(fetch = FetchType.LAZY)
    private Factor factor;
    @Enumerated(EnumType.STRING)
    private Estimation estim;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public Estimation getEstim() {
        return estim;
    }

    public void setEstim(Estimation estim) {
        this.estim = estim;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
