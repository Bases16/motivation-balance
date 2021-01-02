package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Result;

public interface ResultDao {
    Result getResultById(Long id);
    Long saveResult(Result result);
}
