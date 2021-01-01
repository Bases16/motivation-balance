package edu.arf4.motivationbalance.dao;

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
    public List<Factor> getRelevantFactors() {

        String query = "SELECT fr FROM Factor fr WHERE fr.status = 'ACTIVE' ";

        List<Factor> factors = null;

        factors = em.createQuery(query, Factor.class).getResultList();


        return factors;
    }
}
