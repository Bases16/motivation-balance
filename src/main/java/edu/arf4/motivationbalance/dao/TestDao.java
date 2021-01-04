package edu.arf4.motivationbalance.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TestDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;


    public List<Long> getEmployeeIds(Long id) {
        String query = "SELECT e.id from Employee e";
        return em.createQuery(query, Long.class)
                .getResultList();
    }
}
