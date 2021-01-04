package edu.arf4.motivationbalance.dao;

import edu.arf4.motivationbalance.model.EstimationPair;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EstimationDaoImpl implements EstimationPairDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public List<EstimationPair> getRelevEstimPairsByFactorName(String factorName) {
        return em.createQuery(
                "SELECT ep FROM EstimationPair ep WHERE ep.factor.name = :name AND ep.result.isRelevant = true")
                .setParameter("name", factorName)
                .getResultList();
    }
}
