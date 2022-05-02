package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightArrivesBeforeDeparts implements FilterService {
    @Override
    public List<Flight> filterService(List<Flight> flightList) {
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
                .stream()
                .filter(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate())).limit(1)
                .forEach(segment -> list.add(flight)));
        return list;
    }
}