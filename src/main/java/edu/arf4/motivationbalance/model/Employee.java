package edu.arf4.motivationbalance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "emp_id")
    private Set<Result> results = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "manager_id")
    private Set<Employee> subordinates = new HashSet<>();

}
