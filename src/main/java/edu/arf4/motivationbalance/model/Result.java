package edu.arf4.motivationbalance.model;

import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    @Column(updatable = false)
    private LocalDateTime passDatetime;
    private Boolean isRelevant = true;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @org.hibernate.annotations.Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "result", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<EstimationPair> estimationPairs = new HashSet<>();

    protected Result() {}
    public Result(Employee employee, LocalDateTime passingDatetime) {
        this.passDatetime = passingDatetime;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }
    public LocalDateTime getPassDatetime() {
        return passDatetime;
    }
    public Boolean isRelevant() {
        return isRelevant;
    }
    public void setRelevant(Boolean relevant) {
        isRelevant = relevant;
    }
    public Employee getEmployee() {
        return employee;
    }
    public Set<EstimationPair> getEstimationPairs() {
        return estimationPairs;
    }
    public void setEstimationPairs(Set<EstimationPair> estimationPairs) {
        this.estimationPairs = estimationPairs;
    }

}
