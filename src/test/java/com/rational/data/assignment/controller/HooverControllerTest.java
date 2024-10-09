package com.rational.data.assignment.controller;


import com.rational.data.assignment.controller.dto.request.HooverRequestDto;
import com.rational.data.assignment.model.HooverPayload;
import com.rational.data.assignment.model.HooverResult;
import com.rational.data.assignment.service.HooverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HooverControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private HooverService hooverService;


    @Test
    void testHooverEndpoint() {
        // given
        HooverPayload request = new HooverPayload(new int[]{5, 5}, new int[]{3, 4}, new int[][]{{1, 2}, {3, 4}}, "NNESEESWNWW");
        HooverResult response = new HooverResult(new int[]{1, 2}, 3);
        when(hooverService.clean(request)).thenReturn(response);
        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/hoover/clean",
                new HooverRequestDto(new int[]{5, 5}, new int[]{3, 4}, new int[][]{{1, 2}, {3, 4}}, "NNESEESWNWW"),
                String.class);
        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("{\"coords\":[1,2],\"patches\":3}", responseEntity.getBody());
    }


    @Test
    void testHooverEndpoint_constraintViolations() throws Exception {
        // roomSize is not valid
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/hoover/clean",
                new HooverRequestDto(new int[]{0, 5}, new int[]{3, 4}, new int[][]{{1, 2}, {3, 4}}, "NNESEESWNWW"),
                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // coords are not valid
        responseEntity = restTemplate.postForEntity("/hoover/clean",
                new HooverRequestDto(new int[]{5, 5}, new int[]{-3, 4}, new int[][]{{1, 2}, {3, 4}}, "NNESEESWNWW"),
                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // patches are not valid
        responseEntity = restTemplate.postForEntity("/hoover/clean",
                new HooverRequestDto(new int[]{5, 5}, new int[]{3, 4}, new int[][]{{1, 2}, {3}}, "NNESEESWNWW"),
                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // directions are not valid
        responseEntity = restTemplate.postForEntity("/hoover/clean",
                new HooverRequestDto(new int[]{5, 5}, new int[]{3, 4}, new int[][]{{1, 2}, {3, 4}}, "AWEESWNWW"),
                String.class);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}