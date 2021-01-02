package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.model.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    // todo  to test class with own EMF ??
    @Override
    public Result getResultById(Long id) {
        return null;
    }

    @Override
    public Result getRelevantResultByEmpId(Long empId) {
        String query = "SELECT rs FROM Result rs WHERE rs.employee.id = :empId AND rs.isRelevant = true";

        Result result = em.createQuery(query, Result.class)
                .setParameter("empId", empId)
                .getSingleResult();
        return result;
    }

    @Override
    public Long saveResult(Result result) {
        em.persist(result);
        return result.getId();
    }

    @Override
    public List<Result> getAllResultsByEmpId(Long empId) {
        String query = "SELECT rs FROM Result rs WHERE rs.employee.id = :empId";
        return em.createQuery(query, Result.class)
                .setParameter("empId", empId)
                .getResultList();
    }


}
