package com.springboot.app.employee.service;

import com.springboot.app.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);
}
