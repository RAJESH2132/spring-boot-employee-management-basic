package com.springboot.app.employee.dao;

import com.springboot.app.employee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll(){
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //return results
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);
    }
}
