package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.EstimationPairDao;
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
    public List<EstimationPair> getRelevEstimPairsByFactorId(Long factorId) {
        return em.createQuery("SELECT ep FROM EstimationPair ep " +
                  "JOIN FETCH ep.result rs WHERE ep.factor.id = :id AND rs.isRelevant = true")
                .setParameter("id", factorId)
                .getResultList();
    }
}
