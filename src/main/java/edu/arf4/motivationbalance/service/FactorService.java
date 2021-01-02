package edu.arf4.motivationbalance.service;

import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.model.Factor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



}
