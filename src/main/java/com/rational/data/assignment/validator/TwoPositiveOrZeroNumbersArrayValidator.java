package com.rational.data.assignment.validator;

import com.rational.data.assignment.validator.annotation.TwoPositiveOrZeroNumbersArrayConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TwoPositiveOrZeroNumbersArrayValidator implements ConstraintValidator<TwoPositiveOrZeroNumbersArrayConstraint, int[]> {

    @Override
    public void initialize(TwoPositiveOrZeroNumbersArrayConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(int[] value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.length != 2) {
            return false;
        }
        for (int i : value) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
