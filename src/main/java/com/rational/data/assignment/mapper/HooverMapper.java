package com.rational.data.assignment.mapper;

import com.rational.data.assignment.controller.dto.request.HooverRequestDto;
import com.rational.data.assignment.controller.dto.response.HooverResponseDto;
import com.rational.data.assignment.model.HooverPayload;
import com.rational.data.assignment.model.HooverResult;
import org.springframework.stereotype.Component;

@Component
public class HooverMapper {

    public HooverPayload toHooverPayload(HooverRequestDto hooverRequestDto) {
        return HooverPayload.builder()
                .roomSize(hooverRequestDto.getRoomSize())
                .coords(hooverRequestDto.getCoords())
                .patches(hooverRequestDto.getPatches())
                .instructions(hooverRequestDto.getInstructions())
                .build();
    }

    public HooverResponseDto toHooverResponseDto(HooverResult hooverResult) {
        return HooverResponseDto.builder()
                .coords(hooverResult.getCoords())
                .patches(hooverResult.getPatches())
                .build();
    }

}
