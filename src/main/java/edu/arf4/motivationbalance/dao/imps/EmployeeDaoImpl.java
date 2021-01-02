package edu.arf4.motivationbalance.dao.imps;

import edu.arf4.motivationbalance.dao.EmployeeDao;
import edu.arf4.motivationbalance.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public Employee getEmployeeById(Long id, boolean getProxy) {
        Employee emp = null;
        emp = getProxy ? em.getReference(Employee.class, id)
                       : em.find(Employee.class, id);
        return emp;
    }

}
