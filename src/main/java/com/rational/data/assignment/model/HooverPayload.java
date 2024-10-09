package com.rational.data.assignment.model;

import com.rational.data.assignment.validator.annotation.DirectionsConstraint;
import com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint;
import com.rational.data.assignment.validator.annotation.TwoPositiveNumbersArrayConstraint;
import com.rational.data.assignment.validator.annotation.TwoPositiveOrZeroNumbersArrayConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint.PATCHES_VALIDATION_MESSAGE;
import static com.rational.data.assignment.validator.annotation.TwoPositiveNumbersArrayConstraint.ROOM_VALIDATION_MESSAGE;
import static com.rational.data.assignment.validator.annotation.TwoPositiveOrZeroNumbersArrayConstraint.COORDS_VALIDATION_MESSAGE;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class HooverPayload {
    @TwoPositiveNumbersArrayConstraint(message = ROOM_VALIDATION_MESSAGE)
    private int[] roomSize;
    @TwoPositiveOrZeroNumbersArrayConstraint(message = COORDS_VALIDATION_MESSAGE)
    private int[] coords;
    @TwoDimensionArrayPositiveNumberOrZeroConstraint(message = PATCHES_VALIDATION_MESSAGE)
    private int[][] patches;
    @DirectionsConstraint
    private String instructions;
}
