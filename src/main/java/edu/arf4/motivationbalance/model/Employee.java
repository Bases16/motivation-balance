package edu.arf4.motivationbalance.model;

import edu.arf4.motivationbalance.model.enums.Role;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(generator = "MY_ID_GENERATOR")
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @OneToMany(mappedBy = "employee", orphanRemoval = true)
    private Set<Result> results = new HashSet<>();
    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role empRole;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Role getEmpRole() {
        return empRole;
    }

    public void setEmpRole(Role empRole) {
        this.empRole = empRole;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
