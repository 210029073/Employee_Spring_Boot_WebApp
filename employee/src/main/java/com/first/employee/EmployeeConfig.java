package com.first.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    //this essentially seeds the tables
    //performs appropriate housekeepings
    public CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
                Employee maya = new Employee(
                        1L,
                        "Maya Bee",
                        "Beekeeper",
                        LocalDate.of(2002, Month.DECEMBER, 31),
                        LocalDate.of(2003, Month.JANUARY, 1)
                );

                Employee honeycomb = new Employee(
                        2L,
                        "Honeycomb bee",
                        "Worker Bee",
                        LocalDate.of(1956, Month.AUGUST, 23),
                        LocalDate.of(1986, Month.DECEMBER, 1)
                );

            //saves all records to table
            repository.saveAll(List.of(maya, honeycomb));
        };

    }
}
