package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.EstimationPair;
import java.util.List;

public interface EstimationPairDao {
    List<EstimationPair> getRelevEstimPairsByFactorId(Long factorId);
}
