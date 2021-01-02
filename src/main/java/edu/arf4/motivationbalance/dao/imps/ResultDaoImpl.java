package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.ResultDao;
import edu.arf4.motivationbalance.model.Result;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Long saveResult(Result result) {
        em.persist(result);
        return result.getId();
    }
}
