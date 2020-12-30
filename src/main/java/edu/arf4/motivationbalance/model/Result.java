package edu.arf4.motivationbalance.model;

import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Embeddable
public class Result {



    private LocalDateTime passingDatetime;

    private Integer balance;


}
