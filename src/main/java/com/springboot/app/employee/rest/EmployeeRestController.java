package com.springboot.app.employee.rest;

import com.springboot.app.employee.entity.Employee;
import com.springboot.app.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final JsonMapper jsonMapper;

    public EmployeeRestController(EmployeeService employeeService, JsonMapper jsonMapper){
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new NullPointerException("Employee Id not found - "+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //set the id to 0 if we got id as existing then it will become update operation
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }

        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in Request body -"+employeeId);
        }

        Employee patchedEmployee = jsonMapper.updateValue(employee, patchPayload);

        return employeeService.save(patchedEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employees not found -"+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee deleted successfully. EmployeeID: " + employeeId;
    }

}
