package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.model.Factor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactorService {

    private final FactorDao factorDao;

    public FactorService(FactorDao factorDao) {
        this.factorDao = factorDao;
    }

    @Transactional
    public Long createNewFactor(String factorName) {
        Factor factor = new Factor(factorName);
        return factorDao.createFactor(factor);
    }
    //кнопочки восстановить/удалить на конкретном факторе на UI вызовут контроллер, который вызовет это
    @Transactional
    public void changeFactorStatus(String factorName) {
        Factor factor = factorDao.getFactorByName(factorName);
        factor.setStatus(factor.getStatus().getOpposite());
    }

    @Transactional(readOnly = true)
    public List<String> getAllFactorNames() {
        List<Factor> allFactors = factorDao.getAllFactors();
        return allFactors.stream().map(Factor::getName).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> getRelevFactorNames() {
        List<Factor> relevFactors = factorDao.getRelevantFactors();
        return relevFactors.stream().map(Factor::getName).collect(Collectors.toList());
    }
}
