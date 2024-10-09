package com.rational.data.assignment.validator;

import com.rational.data.assignment.validator.annotation.TwoPositiveNumbersArrayConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TwoPositiveNumbersArrayValidator implements ConstraintValidator<TwoPositiveNumbersArrayConstraint, int[]> {

    @Override
    public void initialize(TwoPositiveNumbersArrayConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(int[] value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.length != 2) {
            return false;
        }
        for (int i : value) {
            if (i <= 0) {
                return false;
            }
        }
        return true;
    }
}
