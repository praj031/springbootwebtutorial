package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.annotations.DepartmentValidation;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.annotations.PasswordValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    //Here we define the department DTO, means fields that will be used

    private Long id;
    @NotNull(message = "Title cannot be null")
    private String title;
    private Date createdAt;

    @AssertTrue(message = "The Department should be present ")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Size(min = 5, max = 12, message = "Number of characters in name should be in the range: [5, 12]")
    @PasswordValidation
    private String password;
    @NotNull(message = "Please enter the role")
    private String role; //ADMIN, USER

    @NotNull(message = "Number is required)")
    @DepartmentValidation(message = "Please enter prime number only for variable 'number '")
    private Integer number;

}
