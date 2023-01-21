package com.first.employee;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees() {
        return List.of(
                new Employee(
                        1L,
                        "Maya Bee",
                        "Beekeeper",
                        20,
                        LocalDate.of(2003, Month.JANUARY, 1)
                ),

                new Employee(
                        2L,
                        "Honeycomb bee",
                        "Worker Bee",
                        36,
                        LocalDate.of(1986, Month.DECEMBER, 1)
                )
        );
    }
}
