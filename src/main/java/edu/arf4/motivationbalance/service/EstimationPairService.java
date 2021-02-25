package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.EstimationPairDao;
import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.dto.EstimationPairDto;
import edu.arf4.motivationbalance.model.Factor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimationPairService {
    private final EstimationPairDao estimationPairDao;
    private final FactorDao factorDao;

    public EstimationPairService(EstimationPairDao estimationPairDao, FactorDao factorDao) {
        this.estimationPairDao = estimationPairDao;
        this.factorDao = factorDao;
    }

    @Transactional(readOnly = true)
    public List<EstimationPairDto> getRelevEstimDtoPairsByAllActiveFactors() {
        List<Factor> activeFactors = factorDao.getActiveFactors();
        List<EstimationPairDto> resultList = new ArrayList<>();
        activeFactors.forEach(factor -> resultList
                .addAll(getRelevEstimDtoPairsByFactorId(factor.getId()))
        );
        return resultList;
    }

    private List<EstimationPairDto> getRelevEstimDtoPairsByFactorId(Long factorId) {
        return estimationPairDao.getRelevEstimPairsByFactorId(factorId)
                .stream()
                .map(p -> new EstimationPairDto(p.getFactor().getName(), p.getEstim().name()))
                .collect(Collectors.toList());
    }

}
