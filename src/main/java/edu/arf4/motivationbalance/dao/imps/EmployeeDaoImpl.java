package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.model.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public Employee getEmpById(Long id, boolean getProxy) {
        Employee emp = null;
        emp = getProxy ? em.getReference(Employee.class, id)
                       : em.find(Employee.class, id);
        return emp;
    }

    @Override
    public List<Long> getAllEmpIds() {
        List<Long> idList = em.createQuery("SELECT e.id FROM Employee e", Long.class)
                .getResultList();
        return idList;
    }

    @Override
    public List<Long> getSubordinatesIdsByManagerId(Long id) {
        List<Long> idList = em
                .createQuery("SELECT e.id FROM Employee e WHERE e.manager.id = :id", Long.class)
                .setParameter("id", id)
                .getResultList();

        return idList;
    }

    @Override
    public List<Employee> getAllManagers() {
        List<Employee> managers = em
                .createQuery("SELECT e FROM Employee e WHERE e.empRole = 'MANAGER' ", Employee.class)
                .getResultList();
        return managers;
    }

    @Override
    public void removeEmployee(Employee emp) {
        em.remove(emp);
    }

}
