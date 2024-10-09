package com.rational.data.assignment.validator.annotation;


import com.rational.data.assignment.validator.TwoDimensionArrayPositiveNumberOrZeroConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TwoDimensionArrayPositiveNumberOrZeroConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TwoDimensionArrayPositiveNumberOrZeroConstraint {
    String message() default "This array must contain only arrays of length 2, and all elements must be positive or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String PATCHES_VALIDATION_MESSAGE = "Coords must contain only arrays of length 2, and all elements must be positive or zero";
}