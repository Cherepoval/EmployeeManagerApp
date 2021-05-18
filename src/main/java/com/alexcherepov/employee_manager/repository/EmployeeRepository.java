package com.alexcherepov.employee_manager.repository;

import com.alexcherepov.employee_manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(long id);

    Optional<Employee> findEmployeeById(long id);

}
