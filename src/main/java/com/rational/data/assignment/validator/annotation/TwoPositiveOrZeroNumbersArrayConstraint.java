package com.rational.data.assignment.validator.annotation;

import com.rational.data.assignment.validator.TwoPositiveOrZeroNumbersArrayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TwoPositiveOrZeroNumbersArrayValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TwoPositiveOrZeroNumbersArrayConstraint {
    String message() default "Array must contain exactly 2 positive or zero values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String COORDS_VALIDATION_MESSAGE = "Coords must contain exactly 2 positive or zero values";
}
