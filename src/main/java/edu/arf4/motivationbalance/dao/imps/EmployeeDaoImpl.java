package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public Employee getEmpById(Long id, boolean getReference) {
        return  getReference ? em.getReference(Employee.class, id)
                             : em.find(Employee.class, id);
    }

    @Override
    public void removeEmployee(Employee emp) {
        em.remove(emp);
    }

    @Override
    public List<Long> getAllEmpIds() {
        return em.createQuery("SELECT e.id FROM Employee e", Long.class)
                .getResultList();
    }

    @Override
    public List<Long> getSubordinatesIdsByManagerId(Long id) {
        return em.createQuery("SELECT e.id FROM Employee e WHERE e.manager.id = :id", Long.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Employee> getAllManagers() {
        return em.createQuery("SELECT e FROM Employee e WHERE e.empRole = 'MANAGER' ", Employee.class)
                .getResultList();
    }

    @Override
    public List<Employee> getEmployeesWithoutManagers() {
        return em.createQuery(
                "SELECT e FROM Employee e WHERE e.manager is null AND e.empRole = 'SPECIALIST' ", Employee.class
                ).getResultList();
    }

    @Override
    public List<Employee> searchEmployeeByOneWord(String fir) {
        String query = "SELECT e FROM Employee e WHERE" +
                "(LOWER(e.firstName) LIKE LOWER(CONCAT('%',:fir,'%'))) " +
                                       "OR" +
                "(LOWER(e.lastName) LIKE LOWER(CONCAT('%',:fir,'%')))";

        return em.createQuery(query, Employee.class)
                .setParameter("fir", fir)
                .getResultList();
    }

    @Override
    public List<Employee> searchEmployeeByTwoWords(String fir, String sec) {
        String query = "SELECT e FROM Employee e WHERE" +
                "(LOWER(e.firstName) LIKE LOWER(CONCAT('%',:fir,'%')) AND " +
                "LOWER(e.lastName) LIKE LOWER(CONCAT('%',:sec,'%')))" +
                                       "OR" +
                "(LOWER(e.firstName) LIKE LOWER(CONCAT('%',:sec,'%')) AND " +
                "LOWER(e.lastName) LIKE LOWER(CONCAT('%',:fir,'%')))";

        return em.createQuery(query, Employee.class)
                .setParameter("fir", fir)
                .setParameter("sec", sec)
                .getResultList();
    }

}
