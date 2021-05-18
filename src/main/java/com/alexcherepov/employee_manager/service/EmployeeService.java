package com.alexcherepov.employee_manager.service;

import com.alexcherepov.employee_manager.exeption.UserNotFoundException;
import com.alexcherepov.employee_manager.model.Employee;
import com.alexcherepov.employee_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee newEmployee){
        newEmployee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(newEmployee);
    }

    public Employee updateEmployee(Employee existEmployee){
        return employeeRepository.save(existEmployee);
    }

    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User: " + id + "was not found"));
    }

    public void deleteEmployee(long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
