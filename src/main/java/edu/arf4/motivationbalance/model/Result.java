package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.Estimation;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    @Column(updatable = false)
    private LocalDateTime passingDatetime;
    private Boolean isRelevant = true;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ElementCollection(fetch = FetchType.LAZY)
//    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
    @CollectionTable(name = "estimations")
    @MapKeyJoinColumn(name = "factor_id")
    @Enumerated(EnumType.STRING)
    @Column(name = "estim", updatable = false)
    private Map<Factor, Estimation> estimations = new HashMap<>();


    @OneToMany(mappedBy = "result")
    private Set<EstimationPair> estimationPairs = new HashSet<>();


    protected Result() {}

    public Result(Employee employee, LocalDateTime passingDatetime) {
        this.passingDatetime = passingDatetime;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }
    public void setEstimations(Map<Factor, Estimation> estimations) {
        this.estimations = estimations;
    }

    public void setRelevant(Boolean relevant) {
        isRelevant = relevant;
    }

    public LocalDateTime getPassingDatetime() {
        return passingDatetime;
    }

    public Boolean getRelevant() {
        return isRelevant;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Map<Factor, Estimation> getEstimations() {
        return estimations;
    }

    public Set<EstimationPair> getEstimationPairs() {
        return estimationPairs;
    }

    public void setEstimationPairs(Set<EstimationPair> estimationPairs) {
        this.estimationPairs = estimationPairs;
    }
}
