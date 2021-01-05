package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public User findByUsername(String username) {
        return em.createQuery("SELECT u FROM User u WHERE u.username = :name", User.class)
                .setParameter("name", username)
                .getSingleResult();
    }
}
