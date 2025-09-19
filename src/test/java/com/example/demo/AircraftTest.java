package com.example.demo;

import com.example.demo.model.Aircraft;
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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {

    private Validator validator;
    private Aircraft aircraft;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        aircraft = new Aircraft(
                "Boeing 737",
                "N12345",
                180,
                AircraftStatus.ACTIVE
        );
    }

    // ✅ Test valid aircraft creation
    @Test
    void testValidAircraftCreation() {
        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertTrue(violations.isEmpty(), "Valid aircraft should not produce violations");
        assertEquals("Boeing 737", aircraft.getModel());
        assertEquals("N12345", aircraft.getRegistrationNumber());
        assertEquals(180, aircraft.getCapacity());
        assertEquals(AircraftStatus.ACTIVE, aircraft.getStatus());
    }

    // ✅ Model validation
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void testModelValidation(String invalidModel) {
        aircraft.setModel(invalidModel);

        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertFalse(violations.isEmpty(), "Model should not be null/blank/empty");
    }

    // ✅ Registration number validation
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void testRegistrationNumberValidation(String invalidRegNumber) {
        aircraft.setRegistrationNumber(invalidRegNumber);

        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertFalse(violations.isEmpty(), "Registration number should not be null/blank/empty");
    }

    // ✅ Capacity validation
    @Test
    void testCapacityValidation_Null() {
        aircraft.setCapacity(null);

        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertFalse(violations.isEmpty(), "Capacity must not be null");
    }

    @Test
    void testCapacityValidation_NegativeOrZero() {
        aircraft.setCapacity(0);
        Set<ConstraintViolation<Aircraft>> violationsZero = validator.validate(aircraft);
        assertFalse(violationsZero.isEmpty(), "Capacity must be positive");

        aircraft.setCapacity(-10);
        Set<ConstraintViolation<Aircraft>> violationsNegative = validator.validate(aircraft);
        assertFalse(violationsNegative.isEmpty(), "Capacity must be positive");
    }

    // ✅ Status validation
    @Test
    void testStatusValidation_Null() {
        aircraft.setStatus(null);

        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertFalse(violations.isEmpty(), "Status must not be null");
    }
}
