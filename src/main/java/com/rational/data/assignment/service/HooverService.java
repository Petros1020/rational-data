package com.rational.data.assignment.service;

import com.rational.data.assignment.model.Hoover;
import com.rational.data.assignment.model.HooverPayload;
import com.rational.data.assignment.model.HooverResult;
import com.rational.data.assignment.model.Room;
import org.springframework.stereotype.Service;

@Service
public class HooverService {

    public HooverResult clean(HooverPayload payload) {
        Hoover hoover = new Hoover();
        Room room = new Room(payload.getRoomSize(), payload.getPatches());
        return hoover.clean(room, payload.getCoords(), payload.getInstructions());
    }

}
