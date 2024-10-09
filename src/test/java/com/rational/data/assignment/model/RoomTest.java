package com.rational.data.assignment.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void isPositionDirtyTest() {
        //given
        Room room = new Room(new int[]{3, 3}, new int[][]{{1, 1}, {2, 1}});
        //when
        Room.Position dirty1 = room.getPosition(1, 1);
        Room.Position dirty2 = room.getPosition(2, 1);
        Room.Position notDirty1 = room.getPosition(2, 2);
        Room.Position notDirty2 = room.getPosition(0, 0);
        //then
        assertTrue(dirty1.isDirty());
        assertTrue(dirty2.isDirty());
        assertFalse(notDirty1.isDirty());
        assertFalse(notDirty2.isDirty());
    }


    @Test
    void nextPositionTest() {
        //given
        Room room = new Room(new int[]{3, 3}, new int[][]{{1, 1}});
        Room.Position position = room.getPosition(1, 1);

        //when
        Room.Position south = room.nextPosition(position, 'S');
        //then
        assertEquals(0, south.getY());
        assertEquals(1, south.getX());

        //when
        Room.Position east = room.nextPosition(position, 'E');
        //then
        assertEquals(1, east.getY());
        assertEquals(2, east.getX());

        //when
        Room.Position north = room.nextPosition(position, 'N');
        //then
        assertEquals(2, north.getY());
        assertEquals(1, north.getX());

        //when
        Room.Position west = room.nextPosition(position, 'W');
        //then
        assertEquals(1, west.getY());
        assertEquals(0, west.getX());
    }

    @Test
    void nextPositionTest_doesNotGoOutOfBounds() {
        //given
        Room room = new Room(new int[]{3, 3}, new int[][]{{1, 1}});
        //when
        Room.Position position = room.getPosition(1, 2);
        Room.Position north1 = room.nextPosition(position, 'N');
        Room.Position shouldBeOutOfBounds1 = room.nextPosition(north1, 'N');
        Room.Position shouldBeOutOfBounds2 = room.nextPosition(shouldBeOutOfBounds1, 'N');
        //then
        assertEquals(2, shouldBeOutOfBounds2.getY());
        assertEquals(1, shouldBeOutOfBounds2.getX());
    }

    @Test
    void getPositionTest_success() {
        //given
        Room room = new Room(new int[]{3, 3}, new int[][]{{1, 1}});
        //when //then
        assertDoesNotThrow(() -> {
            room.getPosition(0,0);
            room.getPosition(0,1);
            room.getPosition(0,2);
            room.getPosition(1,0);
            room.getPosition(1,1);
            room.getPosition(1,2);
            room.getPosition(2,0);
            room.getPosition(2,1);
            room.getPosition(2,2);
        });

    }

    @Test
    void getPositionTest_positionOutOfBounds() {
        //given
        Room room = new Room(new int[]{3, 3}, new int[][]{{1, 1}});
        //when //then
        assertThrows(IllegalArgumentException.class, () -> {
            Room.Position outOfBounds = room.getPosition(5,5);
        });

    }



    @Test
    void validationTest_lengthOutOfBounds() {

        assertThrows(IllegalArgumentException.class, () -> {
            Room roomSizeNull = new Room(null, new int[][]{{1, 1}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room widthOutOfBounds = new Room(new int[]{-3, 3}, new int[][]{{1, 1}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room heightOutOfBounds = new Room(new int[]{3, -3}, new int[][]{{1, 1}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room widthZero = new Room(new int[]{0, 3}, new int[][]{{1, 1}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room heightZero = new Room(new int[]{3, 0}, new int[][]{{1, 1}});
        });
    }

    @Test
    void validationTest_patchesValidation() {

        assertThrows(IllegalArgumentException.class, () -> {
            Room patchWidthOutOfBounds = new Room(new int[]{2, 2}, new int[][]{{3, 1}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room patchHeightOutOfBounds = new Room(new int[]{2, 2}, new int[][]{{1, 3}});
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Room patchNull = new Room(new int[]{2, 2}, null);
        });

    }

}