package com.rational.data.assignment.service;

import com.rational.data.assignment.model.HooverPayload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class HooverServiceTest {

    private final HooverService hooverService = new HooverService();

    @Test
    void testClean() {
        // given
        HooverPayload payload = new HooverPayload(new int[]{5, 5}, new int[]{1, 2}, new int[][]{{1, 2}, {2, 3}}, "NNESEESWNWW");

        // when // then
        assertDoesNotThrow(() -> hooverService.clean(payload));
    }
}