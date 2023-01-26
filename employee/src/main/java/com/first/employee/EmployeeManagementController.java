package com.first.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;

@Controller
public class EmployeeManagementController {
    @Autowired
    private EmployeeRepository employeeRepository;
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
}
