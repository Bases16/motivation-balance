package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EstimationPairDao;
import edu.arf4.motivationbalance.dto.EstimationPairDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimationPairService {

    private final EstimationPairDao estimationPairDao;

    public EstimationPairService(EstimationPairDao estimationPairDao) {
        this.estimationPairDao = estimationPairDao;
    }

    @Transactional(readOnly = true)
    public List<EstimationPairDto> getRelevEstimDtoPairsByFactorName(String factorName) {
        return estimationPairDao.getRelevEstimPairsByFactorName(factorName).stream()
                .map(p -> new EstimationPairDto(p.getFactor().getName(), p.getEstim().name()))
                .collect(Collectors.toList());
    }
}
