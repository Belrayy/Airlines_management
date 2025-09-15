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

    // Test valid aircraft creation
    @Test
    void testValidAircraftCreation() {
        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertEquals("Boeing 737", aircraft.getModel());
        assertEquals("N12345", aircraft.getRegistrationNumber());
        assertEquals(180, aircraft.getCapacity());
        assertEquals(AircraftStatus.ACTIVE, aircraft.getStatus());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void testModelValidation(String invalidModel) {
        aircraft.setModel(invalidModel);

        Set<ConstraintViolation<Aircraft>> violations = validator.validate(aircraft);

        assertFalse(violations.isEmpty(), "Model should not be empty");
    }
}
