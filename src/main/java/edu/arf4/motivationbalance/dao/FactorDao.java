package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Factor;

import java.util.List;

public interface FactorDao {
    List<Factor> getRelevantFactors();
    Factor getFactorByName(String name);
}
