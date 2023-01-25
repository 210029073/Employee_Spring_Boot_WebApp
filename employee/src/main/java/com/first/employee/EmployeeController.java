package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController //A controller that provides the RESTFul Api
//@RequestMapping(path="api/employee") //sets a path/route for controller retrieving service
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    //provides dependencies injection for employeeService for providing single instance
    //controlling what requests the instance
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/api/employee") //retrieves the list of employees from EmployeeService class
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

}
