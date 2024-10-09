package com.rational.data.assignment.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HooverTest {

    private Hoover hoover = new Hoover();

    @Test
    void cleanTest_success1() {
        //given
        Room room = new Room(new int[]{5, 5}, new int[][]{{1, 0}, {2, 2}, {2, 3}});
        //when
        HooverResult result = hoover.clean(room, new int[]{1, 2}, "NNESEESWNWW");
        //then
        assertEquals(1, result.getCoords()[0]);
        assertEquals(3, result.getCoords()[1]);
        assertEquals(1, result.getPatches());
    }

    @Test
    void cleanTest_success2() {
        //given
        Room room = new Room(new int[]{5, 5}, new int[][]{{1, 4}, {2, 2}, {2, 1}});
        //when
        HooverResult result = hoover.clean(room, new int[]{0, 0}, "NNNNEESSSSWNNN");
        //then
        assertEquals(1, result.getCoords()[0]);
        assertEquals(3, result.getCoords()[1]);
        assertEquals(3, result.getPatches());
    }

    @Test
    void cleanTest_success3() {
        //given
        Room room = new Room(new int[]{6, 5}, new int[][]{{1, 4}, {2, 2}, {2, 1}, {3,3}, {5,1}});
        //when
        HooverResult result = hoover.clean(room, new int[]{1, 3}, "ESENEESS");
        //then
        assertEquals(5, result.getCoords()[0]);
        assertEquals(1, result.getCoords()[1]);
        assertEquals(3, result.getPatches());
    }

    @Test
    void cleanTest_goOutOfBounds() {
        //given
        Room room = new Room(new int[]{6, 5}, new int[][]{{1, 4}, {2, 2}, {2, 1}, {3,3}, {5,1}});
        //when
        HooverResult result = hoover.clean(room, new int[]{1, 3}, "SSSSSSSSSSSS");
        //then
        assertEquals(1, result.getCoords()[0]);
        assertEquals(0, result.getCoords()[1]);
        assertEquals(0, result.getPatches());
    }

    @Test
    void cleanTest_goToDirtyManyTimes() {
        //given
        Room room = new Room(new int[]{6, 5}, new int[][]{{1, 4}, {2, 2}, {2, 1}, {3,3}, {5,1}});
        //when
        HooverResult result = hoover.clean(room, new int[]{1, 3}, "NESSWNNESSWNNE");
        //then
        assertEquals(2, result.getCoords()[0]);
        assertEquals(4, result.getCoords()[1]);
        assertEquals(2, result.getPatches());
    }

}