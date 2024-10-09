package com.rational.data.assignment.validator.annotation;

import com.rational.data.assignment.validator.DirectionsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DirectionsValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface DirectionsConstraint {
    String message() default "Invalid directions. Only N, S, E, W are allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
