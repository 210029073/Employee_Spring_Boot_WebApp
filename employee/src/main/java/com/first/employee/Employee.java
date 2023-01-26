package com.first.employee;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false, length = 62)
    private String name;
    private String role;
    private int age;
    private LocalDate DATE_OF_BIRTH;
    private LocalDate join_date;

     Employee(Long id, String name, String role, LocalDate DOB, LocalDate join_date) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.DATE_OF_BIRTH = DOB;
         this.age = (LocalDate.now().getYear() - this.DATE_OF_BIRTH.getYear());
        this.join_date = join_date;
    }

    public Employee() {
        this.name = "";
        this.role = "";
        this.age = 0;
        this.join_date = null;
    }

    public LocalDate getDATE_OF_BIRTH() {
         return this.DATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(LocalDate DATE_OF_BIRTH) {
         this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
         return this.age = LocalDate.now().getYear() - DATE_OF_BIRTH.getYear();
    }
    public LocalDate getJoin_date() {
        return join_date;
    }

    public void setJoin_date(LocalDate join_date) {
        this.join_date = join_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", join_date=" + join_date +
                '}';
    }
}
