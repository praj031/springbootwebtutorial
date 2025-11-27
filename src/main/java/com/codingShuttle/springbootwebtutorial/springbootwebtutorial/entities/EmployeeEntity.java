package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    //This is the class where we deifine our database things and by making @Entity we tell our compiler that the following class will link to JDBC and alll the process
    //This is the class that you need to convert as table inside the h2 database.
    // Basically here we will define the field name and all colum name inside the database.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    //Default Constructor
    public EmployeeEntity(){

    }

}
