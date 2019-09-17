package com.okta.springbootvue.Controller;

import com.okta.springbootvue.Entity.Employee;
import com.okta.springbootvue.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;
    
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/doctorName")
    public Collection<Employee> doctorNames() {
        return employeeRepository.findAll().stream().collect(Collectors.toList());
    }

}
