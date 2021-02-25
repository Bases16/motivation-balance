package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.FactorStatus;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factors")
@BatchSize(size = 10)
public class Factor {
    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    @Column(unique = true, updatable = false)
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FactorStatus status = FactorStatus.ACTIVE;


    protected Factor() {}
    public Factor(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public FactorStatus getStatus() {
        return status;
    }
    public void setStatus(FactorStatus status) {
        this.status = status;
    }
}
