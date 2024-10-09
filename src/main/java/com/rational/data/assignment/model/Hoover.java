package com.rational.data.assignment.model;

public class Hoover {

    /**
     * Cleans the room based on the instructions given
     * @param room the room to clean
     * @param cords the initial position of the hoover
     * @param instructions the instructions to follow
     * @return the result of the cleaning
     */
    public HooverResult clean(Room room, int[] cords, String instructions) {
        Room.Position position = room.getPosition(cords[0], cords[1]);
        int cleanedPatches = 0;

        //before going inside the loop we need to check if the initial position is dirty
        if (position.isDirty()) {
            cleanedPatches++;
        }
        position.clean();

        for (char instruction : instructions.toCharArray()) {
            position = room.nextPosition(position, instruction);

            // this happens in order to avoid counting the same patch twice
            if (position.isVisited()){
                continue;
            }

            if (position.isDirty()) {
                cleanedPatches++;
            }
            position.clean();
        }

        return HooverResult.builder()
                .coords(new int[]{position.getX(), position.getY()})
                .patches(cleanedPatches)
                .build();
    }


}
