package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DepartureBeforeCurrentTime implements FilterService {
    @Override
    public List<Flight> filterService(List<Flight> flightList) {
        LocalDateTime timeNow = LocalDateTime.now();
        List<Flight> list = new ArrayList<>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (timeNow.isAfter(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }
        return list;
    }
}


