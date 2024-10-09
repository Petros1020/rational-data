package com.rational.data.assignment.controller.dto.request;

import com.rational.data.assignment.validator.annotation.DirectionsConstraint;
import com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint;
import com.rational.data.assignment.validator.annotation.TwoPositiveNumbersArrayConstraint;
import com.rational.data.assignment.validator.annotation.TwoPositiveOrZeroNumbersArrayConstraint;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint.PATCHES_VALIDATION_MESSAGE;
import static com.rational.data.assignment.validator.annotation.TwoPositiveNumbersArrayConstraint.ROOM_VALIDATION_MESSAGE;
import static com.rational.data.assignment.validator.annotation.TwoPositiveOrZeroNumbersArrayConstraint.COORDS_VALIDATION_MESSAGE;

@Schema(description = "Request payload containing the room dimensions, initial position, and dirt patches")
@AllArgsConstructor
@Builder
@Getter
public class HooverRequestDto {
    @Schema(description = "Room dimensions. Array with 2 positive integers.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[5, 5]")
    @TwoPositiveNumbersArrayConstraint(message = ROOM_VALIDATION_MESSAGE)
    private int[] roomSize;

    @Schema(description = "Initial position of the hoover. Array with 2 positive integers or zero.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @TwoPositiveOrZeroNumbersArrayConstraint(message = COORDS_VALIDATION_MESSAGE)
    private int[] coords;

    @Schema(description = "Positions of dirt patches. Must be in range of the room size.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[[1, 0], [2, 2], [2, 3]]")
    @TwoDimensionArrayPositiveNumberOrZeroConstraint(message = PATCHES_VALIDATION_MESSAGE)
    private int[][] patches;

    @Schema(description = "Instructions for the hoover.", requiredMode = Schema.RequiredMode.REQUIRED, example = "NNESEESWNWW", allowableValues = "N, S, E, W")
    @DirectionsConstraint
    private String instructions;
}
