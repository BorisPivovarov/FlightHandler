package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);

        System.out.println("Вывод всех полётов:");
        printFlightList(flights);

        firstCondition(flightFilter);
        secondCondition(flightFilter);
        thirdCondition(flightFilter);

    }

    private static void thirdCondition(FlightFilter flightFilter) {
        System.out.println("Общее время, проведённое на земле превышает два часа:");
        flightFilter.setFilter(new TransitMoreThanTwoHours());
        printFlightList(flightFilter.executeFilter());
    }

    private static void secondCondition(FlightFilter flightFilter) {
        System.out.println("Имеются сегменты с датой прилёта раньше даты вылета:");
        flightFilter.setFilter(new FlightArrivesBeforeDeparts());
        printFlightList(flightFilter.executeFilter());
    }

    private static void firstCondition(FlightFilter flightFilter) {
        System.out.println("Вылет до текущего момента времени:");
        flightFilter.setFilter(new DepartureBeforeCurrentTime());
        printFlightList(flightFilter.executeFilter());
    }

    public static void printFlightList(List<Flight> list) {
        System.out.println(list);
    }
}

