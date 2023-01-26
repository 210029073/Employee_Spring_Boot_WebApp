package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    public List<Employee> getEmployees() {
//        return List.of(
//                new Employee(
//                        1L,
//                        "Maya Bee",
//                        "Beekeeper",
//                        20,
//                        LocalDate.of(2003, Month.JANUARY, 1)
//                ),
//
//                new Employee(
//                        2L,
//                        "Honeycomb bee",
//                        "Worker Bee",
//                        36,
//                        LocalDate.of(1986, Month.DECEMBER, 1)
//                )
//        );
//    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
