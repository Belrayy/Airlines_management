package com.example.demo;

import com.example.demo.model.Airport;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    private Validator validator;
    private Airport airport;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        airport = new Airport(
                "JFK",
                "John F. Kennedy International Airport",
                "New York"
        );
    }

    @Test
    void testValidAirport() {
        Set<ConstraintViolation<Airport>> violations = validator.validate(airport);
        assertTrue(violations.isEmpty(), "A valid airport should not have violations");

        assertEquals("JFK", airport.getAirportId());
        assertEquals("John F. Kennedy International Airport", airport.getAirportName());
        assertEquals("New York", airport.getCity());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "AA", "ABCD"})
    void testInvalidAirportId(String invalidId) {
        airport.setAirportId(invalidId);

        Set<ConstraintViolation<Airport>> violations = validator.validate(airport);

        assertFalse(violations.isEmpty(), "Invalid airportId should trigger violations");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidAirportName(String invalidName) {
        airport.setAirportName(invalidName);

        Set<ConstraintViolation<Airport>> violations = validator.validate(airport);

        assertFalse(violations.isEmpty(), "Invalid airportName should trigger violations");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void testInvalidCity(String invalidCity) {
        airport.setCity(invalidCity);

        Set<ConstraintViolation<Airport>> violations = validator.validate(airport);

        assertFalse(violations.isEmpty(), "Invalid city should trigger violations");
    }
}
