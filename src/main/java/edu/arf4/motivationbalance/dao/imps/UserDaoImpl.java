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
    public User findByUsername(String email) {
        User user = null;
        try {
            user = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                     .setParameter("email", email)
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

    @Override
    public User getUserByEmpId(Long empId) {
        return em.createQuery("SELECT u FROM User u WHERE u.employee.id = :id", User.class)
                .setParameter("id", empId)
                .getSingleResult();
    }

}
