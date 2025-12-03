package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = DepartmentValidator.class)
public @interface DepartmentValidation {
    String message() default "The entered value is not prime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
/*

In this file I am defining the structure of the validation, means how it will behave.

 */