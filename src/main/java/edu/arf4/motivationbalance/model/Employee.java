package edu.arf4.motivationbalance.model;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @ElementCollection
//    @CollectionTable(name = "results")
    @CollectionTable(name = "results",
                     joinColumns = @JoinColumn(name = "emp_id"))
    Set<Result> results = new HashSet<>();

}
