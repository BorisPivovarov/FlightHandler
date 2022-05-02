package com.gridnine.testing;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TransitMoreThanTwoHoursTest extends AbstractFlightTest{
    public TransitMoreThanTwoHoursTest() {
        super(new TransitMoreThanTwoHours());
    }

    @Before
    public void setUp() {
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
    }

    @Test
    public void filter() {
        final List<Flight> actualList = filterTest.filterService(flights);
        final List<Flight> expectedList = Collections.singletonList(flight4);
        assertEquals(expectedList, actualList);
        assertEquals(1, actualList.size());
    }
}