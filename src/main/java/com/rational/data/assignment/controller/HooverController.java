package com.rational.data.assignment.controller;

import com.rational.data.assignment.controller.dto.request.HooverRequestDto;
import com.rational.data.assignment.controller.dto.response.HooverResponseDto;
import com.rational.data.assignment.mapper.HooverMapper;
import com.rational.data.assignment.service.HooverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hoover")
@Validated
public class HooverController {

    private final HooverService hooverService;
    private final HooverMapper hooverMapper;

    @PostMapping("/clean")
    @Operation(summary = "Clean the room using the Hoover", description = "Provide room dimensions, initial position, and dirt patches to clean the room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully cleaned the room"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public HooverResponseDto clean(@Valid @RequestBody HooverRequestDto hooverRequestDto) {
        return hooverMapper.toHooverResponseDto(hooverService.clean(hooverMapper.toHooverPayload(hooverRequestDto)));
    }

}
