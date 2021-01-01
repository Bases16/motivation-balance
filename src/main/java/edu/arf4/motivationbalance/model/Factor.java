package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.FactorStatus;

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
public class Factor {
    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    @Column(unique = true, updatable = false)
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private FactorStatus status;


    public String getName() {
        return name;
    }
}
