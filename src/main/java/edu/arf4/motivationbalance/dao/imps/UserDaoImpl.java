package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.UserDao;
import edu.arf4.motivationbalance.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            user = em.createQuery("SELECT u FROM User u WHERE u.username = :name", User.class)
                     .setParameter("name", username)
                     .getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Long createUser(User user) {
        em.persist(user);
        return user.getId();
    }


}
