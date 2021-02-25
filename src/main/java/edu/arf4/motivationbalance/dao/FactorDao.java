package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Factor;
import java.util.List;

public interface FactorDao {
    List<Factor> getActiveFactors();
    List<Factor> getAllFactors();
    Factor getFactorByName(String name);
    Long createFactor(Factor factor);
}
