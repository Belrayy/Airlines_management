package com.example.demo.dto;

import com.example.demo.model.enums.AircraftStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AircraftDTO {

    private Long id;

    @NotBlank(message="Model is required")
    private String model;

    @NotBlank(message="Registration number is required")
    private String registrationNumber;

    @NotNull(message= "Capacity is required")
    @Positive(message= "Capacity must be positive")
    private Integer capacity;

    @NotNull(message="Status is required")
    private AircraftStatus status;
}
