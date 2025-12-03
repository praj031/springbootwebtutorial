package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date createdAt;
    @JsonProperty("isActive")
    private Boolean isActive;
    private String password;
    private String role; //ADMIN, USER
    private Integer number;


}
