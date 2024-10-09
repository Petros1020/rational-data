package com.rational.data.assignment.mapper;


import com.rational.data.assignment.controller.dto.request.HooverRequestDto;
import com.rational.data.assignment.controller.dto.response.HooverResponseDto;
import com.rational.data.assignment.model.HooverPayload;
import com.rational.data.assignment.model.HooverResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HooverMapperTest {
    private final HooverMapper hooverMapper = new HooverMapper();

    @Test
    void testToHooverPayload() {
        // having
        HooverRequestDto hooverRequestDto = new HooverRequestDto(
                new int[]{5, 5},
                new int[]{1, 2},
                new int[][]{{1, 2}, {2, 3}},
                "NNESEESWNWW"
        );

        // when
        HooverPayload hooverPayload = hooverMapper.toHooverPayload(hooverRequestDto);

        // then
        assertEquals(hooverRequestDto.getRoomSize(), hooverPayload.getRoomSize());
        assertEquals(hooverRequestDto.getCoords(), hooverPayload.getCoords());
        assertEquals(hooverRequestDto.getPatches(), hooverPayload.getPatches());
        assertEquals(hooverRequestDto.getInstructions(), hooverPayload.getInstructions());
    }

    @Test
    void testToHooverResponseDto() {
        // having
        HooverResult hooverResult = new HooverResult(new int[]{1, 2}, 3);

        // when
        HooverResponseDto hooverResponseDto = hooverMapper.toHooverResponseDto(hooverResult);

        // then
        assertEquals(hooverResult.getCoords(), hooverResponseDto.getCoords());
        assertEquals(hooverResult.getPatches(), hooverResponseDto.getPatches());
    }
}