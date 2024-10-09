package com.rational.data.assignment.model;

import com.rational.data.assignment.validator.SelfValidate;
import com.rational.data.assignment.validator.annotation.TwoDimensionArrayPositiveNumberOrZeroConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Room implements SelfValidate<Room> {

    @Positive
    private final int lengthX;
    @Positive
    private final int lengthY;
    @TwoDimensionArrayPositiveNumberOrZeroConstraint
    @NotNull
    private final int[][] patches; // mainly for validation reasons
    private final Position[][] position;

    public Room(int[] roomSize, int[][] patches) {
        if (roomSize == null) {
            throw new IllegalArgumentException("Room size must not be null");
        }
        this.lengthX = roomSize[0];
        this.lengthY = roomSize[1];
        this.patches = patches;

        this.validateSelf();

        position = new Position[roomSize[0]][roomSize[1]];
        for (int i = 0; i < roomSize[0]; i++) {
            for (int j = 0; j < roomSize[1]; j++) {
                boolean isDirty = false;

                // sacrificed performance for making Position immutable
                for (int[] patch : patches) {
                    if (patch[0] == i && patch[1] == j) {
                        isDirty = true;
                        break;
                    }
                }
                position[i][j] = new Position(i, j, isDirty);
            }
        }

    }

    @Override
    public void additionalValidation() {
        // additional validation to check whether patches are within bounds or not.
        for (int[] patch : patches) {
            if (patch[0] >= lengthX || patch[1] >= lengthY) {
                throw new IllegalArgumentException("Patch is out of bounds");
            }
        }
    }

    public Position getPosition(int x, int y) {
        if (x >= lengthX || y >= lengthY) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        return position[x][y];
    }


    public Position nextPosition(Position currentPosition, char direction) {
        return switch (direction) {
            case 'N' -> currentPosition.goNorth();
            case 'S' -> currentPosition.goSouth();
            case 'E' -> currentPosition.goEast();
            case 'W' -> currentPosition.goWest();
            default -> currentPosition;
        };
    }

    @Getter
    @EqualsAndHashCode
    @RequiredArgsConstructor
    class Position {
        private final int x;
        private final int y;
        private final boolean isDirty;
        private boolean visited = false;

        Position goNorth() {
            if (y + 1 >= lengthY) {
                return this;
            }
            return position[x][y + 1];
        }

        Position goSouth() {
            if (y - 1 < 0) {
                return this;
            }
            return position[x][y - 1];
        }

        Position goEast() {
            if (x + 1 >= lengthX) {
                return this;
            }
            return position[x + 1][y];
        }

        Position goWest() {
            if (x - 1 < 0) {
                return this;
            }
            return position[x - 1][y];
        }

        void clean() {
            visited = true;
        }
    }
}
