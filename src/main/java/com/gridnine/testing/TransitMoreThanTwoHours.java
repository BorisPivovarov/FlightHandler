package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TransitMoreThanTwoHours implements FilterService {
    @Override
    public List<Flight> filterService(List<Flight> flightList) {
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1) {
                int count = 0;
                for (int i = 1; i < size; i++) {
                    count += transitTime(flight.getSegments().get(i - 1).getArrivalDate(),
                            flight.getSegments().get(i).getDepartureDate());
                }
                if (count > 2) {
                    list.add(flight);
                }
            }
        });
        return list;
    }

    public int transitTime(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
