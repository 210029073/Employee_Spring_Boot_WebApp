package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController //A controller that provides the RESTFul Api
@RequestMapping(path="api/employee") //sets a path/route for controller retrieving service
public class EmployeeController {

    private final EmployeeService employeeService;

    //provides dependencies injection for employeeService for providing single instance
    //controlling what requests the instance
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping //retrieves the list of employees from EmployeeService class
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
