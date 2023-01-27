package com.first.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByRole(String role);
    void deleteEmployeeById(Long id);
    List<Employee> findEmployeeByName(String name);
}
