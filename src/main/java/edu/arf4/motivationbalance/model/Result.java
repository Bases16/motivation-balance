package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.Estimation;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    @Column(updatable = false)
    private LocalDateTime passingDatetime;
    @ElementCollection
    @CollectionTable(name = "estimations")
    @MapKeyJoinColumn(name = "factor_id")
    @Enumerated(EnumType.STRING)
    @Column(name = "estim", updatable = false)
    private Map<Factor, Estimation> estimations = new HashMap<>();




}
