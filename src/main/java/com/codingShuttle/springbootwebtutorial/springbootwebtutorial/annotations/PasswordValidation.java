package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValidation {

    String message() default "Password must be at least 10 characters and contain at least one uppercase, one lowercase and one special character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}