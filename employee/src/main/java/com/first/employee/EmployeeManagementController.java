package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeManagementController {
    @Autowired
    private EmployeeRepository employeeRepository; //bad practice do not access the repository

    @Autowired
    private final EmployeeService employeeService; //we use services to do the actual logic

    public EmployeeManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee",new Employee());
        return "register";
    }

    @PostMapping("/process_register")
    public String registerEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "index";
    }

    @GetMapping("/delete")
    public String searchEmployeeForDeletion(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return  "delete";
    }

    @GetMapping("/employee/deleteSuccess")
    @Transactional
    public String deleteEmployee(@RequestParam Long employeeID) {
        if(employeeID == 0) System.out.println("Employee does not hold any details");
        else System.out.println("ID: " + employeeID);
        employeeService.deleteEmployee(employeeID);
        return "index";
    }

    @GetMapping("/employee/viewAll")
    public String enumerateEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "viewAllEmployees";
    }

    @GetMapping("/search")
    public String findEmployeesByName(Model model) {
        model.addAttribute("name", "");
        return "index";
    }

    @PostMapping("/search")
    public String findEmployeesByName(Model model, String name) {
        if(employeeService.findEmployeeByName(name) != null) {
            List<Employee> foundEmployees = employeeService.findEmployeeByName(name);
            model.addAttribute("employees", foundEmployees);
        }
        return "index";
    }
}
