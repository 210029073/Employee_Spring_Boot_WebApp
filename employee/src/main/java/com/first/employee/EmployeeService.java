package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        System.out.println(this.getClass().getName());
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeeByName(String name) {
        for(int i = 0; i < employeeRepository.findEmployeeByName(name).size(); i++) {
            if(employeeRepository.findEmployeeByName(name).contains(employeeRepository.findEmployeeByName(name).get(i)) &&
                    i < employeeRepository.findEmployeeByName(name).size()) {
                return employeeRepository.findEmployeeByName(name);
            }
        }
//bug!!!
//        if(employeeRepository.findEmployeeByName(name).isEmpty() || name == null) {
//            throw new IllegalStateException("No Employees found from search criteria: \'" + name + "\'");
//        }

        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
