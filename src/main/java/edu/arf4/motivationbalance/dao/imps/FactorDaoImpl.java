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
        String query = "SELECT fr FROM Factor fr WHERE fr.status = 'ACTIVE' ";
        List<Factor> factors = null;
        factors = em.createQuery(query, Factor.class).getResultList();
        return factors;
    }

    @Override
    public List<Factor> getAllFactors() {
        String query = "SELECT fr FROM Factor fr";
        List<Factor> factors = null;
        factors = em.createQuery(query, Factor.class).getResultList();
        return factors;
    }

    @Override
    public Factor getFactorByName(String name) {
        String query = "SELECT fr FROM Factor fr WHERE fr.name = :name";
        Factor factor = em.createQuery(query, Factor.class)
                .setParameter("name", name)
                .getSingleResult();
        return factor;
    }

    @Override
    public Long createFactor(Factor factor) {
        em.persist(factor);
        return factor.getId();
    }


}
