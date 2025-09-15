package com.example.demo;

import com.example.demo.model.Flight;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Validator validator;
    private Flight flight;
    private Date departureTime;
    private Date arrivalTime;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Calendar cal = Calendar.getInstance();
        departureTime = cal.getTime();
        cal.add(Calendar.HOUR, 2); // arrival 2 hours later
        arrivalTime = cal.getTime();

        flight = new Flight(
                "TK167",
                "Turkish Airlines",
                "LAX",
                "AMS",
                departureTime,
                arrivalTime,
                300
        );
    }

    @Test
    void testValidFlight() {
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertTrue(violations.isEmpty(), "Valid flight should not produce violations");

        assertEquals("TK167", flight.getFlightNumber());
        assertEquals("Turkish Airlines", flight.getAirline());
        assertEquals("LAX", flight.getOrigin());
        assertEquals("AMS", flight.getDestination());
        assertEquals(departureTime, flight.getDepartureTime());
        assertEquals(arrivalTime, flight.getArrivalTime());
        assertEquals(300, flight.getCapacity());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidFlightNumber(String invalidNumber) {
        flight.setFlightNumber(invalidNumber);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Flight number should not be null/blank");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidAirline(String invalidAirline) {
        flight.setAirline(invalidAirline);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Airline should not be null/blank");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidOrigin(String invalidOrigin) {
        flight.setOrigin(invalidOrigin);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Origin should not be null/blank");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidDestination(String invalidDestination) {
        flight.setDestination(invalidDestination);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Destination should not be null");
    }

    @Test
    void testNullDepartureTime() {
        flight.setDepartureTime(null);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Departure time should not be null");
    }

    @Test
    void testNullArrivalTime() {
        flight.setArrivalTime(null);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Arrival time should not be null");
    }

    @Test
    void testNegativeCapacity() {
        flight.setCapacity(-10);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Capacity must be positive");
    }

    @Test
    void testZeroCapacity() {
        flight.setCapacity(0);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Capacity must be positive");
    }
}
