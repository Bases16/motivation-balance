package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.Result;

import java.util.List;
import java.util.Map;

public interface ResultDao {
    Result getResultById(Long id);
    Result getRelevantResultByEmpId(Long empId);
    Long saveResult(Result result);
    List<Result> getAllResultsByEmpId(Long empId);
    List<Result> getAllRelevResultsByEmpIds(List<Long> ids);
}
