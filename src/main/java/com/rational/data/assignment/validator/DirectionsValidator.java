package com.rational.data.assignment.validator;

import com.rational.data.assignment.validator.annotation.DirectionsConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DirectionsValidator implements ConstraintValidator<DirectionsConstraint, String> {
    @Override
    public void initialize(DirectionsConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return s.matches("[NSEW]*");
    }
}
