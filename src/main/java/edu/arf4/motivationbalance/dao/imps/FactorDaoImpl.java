package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.FactorDao;
import edu.arf4.motivationbalance.model.Factor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FactorDaoImpl implements FactorDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public List<Factor> getActiveFactors() {
        return em.createQuery("SELECT fr FROM Factor fr WHERE fr.status = 'ACTIVE' ", Factor.class)
                .getResultList();
    }

    @Override
    public List<Factor> getAllFactors() {
        return em.createQuery("SELECT fr FROM Factor fr", Factor.class)
                .getResultList();
    }

    @Override
    public Factor getFactorByName(String name) {
        return em.createQuery("SELECT fr FROM Factor fr WHERE fr.name = :name", Factor.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Long createFactor(Factor factor) {
        em.persist(factor);
        return factor.getId();
    }


}
