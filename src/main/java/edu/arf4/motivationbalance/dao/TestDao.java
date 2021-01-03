package edu.arf4.motivationbalance.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class TestDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;



    public Map<?, ?> getEstimationsByResultId(Long id) {
        String query = "SELECT rs.estimations FROM Result rs WHERE rs.id = :id";
        return em.createQuery(query, Map.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Long> getEmployeeIds(Long id) {
        String query = "SELECT e.id from Employee e";
        return em.createQuery(query, Long.class)
                .getResultList();
    }
}
