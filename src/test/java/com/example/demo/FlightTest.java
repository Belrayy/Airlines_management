package com.example.demo;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.model.Flight;
import com.example.demo.model.enums.AircraftStatus;
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
    private Airport origin;
    private Airport destination;
    private Aircraft aircraft;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Calendar cal = Calendar.getInstance();
        departureTime = cal.getTime();
        cal.add(Calendar.HOUR, 2); // arrival 2 hours later
        arrivalTime = cal.getTime();

        // Mock objects (you can adjust fields if Airport has more)
        origin = new Airport();
        origin.setAirportName("Los Angeles Intl");
        origin.setCity("Los Angeles");

        destination = new Airport();
        destination.setAirportName("Amsterdam Schiphol");
        destination.setCity("Amsterdam");

        aircraft = new Aircraft("Boeing 737", "N12345", 300, AircraftStatus.ACTIVE);

        flight = new Flight(
                "TK167",
                "Turkish Airlines",
                origin,
                destination,
                departureTime,
                arrivalTime,
                aircraft
        );
    }

    @Test
    void testValidFlight() {
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertTrue(violations.isEmpty(), "Valid flight should not produce violations");

        assertEquals("TK167", flight.getFlightNumber());
        assertEquals("Turkish Airlines", flight.getAirline());
        assertEquals(origin, flight.getOrigin());
        assertEquals(destination, flight.getDestination());
        assertEquals(departureTime, flight.getDepartureTime());
        assertEquals(arrivalTime, flight.getArrivalTime());
        assertEquals(300, flight.getAircraft().getCapacity());
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

    @Test
    void testNullOrigin() {
        flight.setOrigin(null);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Origin should not be null");
    }

    @Test
    void testNullDestination() {
        flight.setDestination(null);
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
    void testNullAircraft() {
        flight.setAircraft(null);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty(), "Aircraft should not be null");
    }
}
