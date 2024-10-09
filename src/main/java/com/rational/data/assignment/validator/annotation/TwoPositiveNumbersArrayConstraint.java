package com.rational.data.assignment.validator.annotation;


import com.rational.data.assignment.validator.TwoPositiveNumbersArrayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TwoPositiveNumbersArrayValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TwoPositiveNumbersArrayConstraint {
    String message() default "Array must contain exactly 2 positive values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String ROOM_VALIDATION_MESSAGE = "Room must contain exactly 2 positive values";

}
