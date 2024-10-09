package com.rational.data.assignment.validator;

import com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
* This validator checks that a 2D array, contains only arrays of length 2,
* and that all elements are positive or zero.
*/
public class TwoDimensionArrayPositiveNumberOrZeroConstraintValidator implements ConstraintValidator<TwoDimensionArrayPositiveNumberOrZeroConstraint, int[][]> {

    @Override
    public void initialize(TwoDimensionArrayPositiveNumberOrZeroConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(int[][] value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        for (int[] ints : value) {
            if (ints.length != 2) {
                return false;
            }
            for (int i : ints) {
                if (i < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
