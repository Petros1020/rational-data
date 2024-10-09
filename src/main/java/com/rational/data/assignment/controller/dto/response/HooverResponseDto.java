package com.rational.data.assignment.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Schema(description = "Response payload containing the final position and number of patches cleaned")
@Getter
@Builder
@AllArgsConstructor
public class HooverResponseDto {
    @Schema(description = "Final position of the hoover", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 3]")
    private int[] coords;

    @Schema(description = "Number of patches cleaned", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private int patches;
}
