package com.example.demo.dto;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FlightDTO {

    private Long id;

    @NotBlank(message = "Flight number is required")
    private String flightNumber;

    @NotBlank(message = "Airline is required")
    private String airline;

    @NotNull(message = "Origin of flight is required")
    private Airport origin;

    @NotNull(message = "Destination of flight is required")
    private Airport destination;

    @NotNull(message = "Departure time is required")
    private Date departureTime;

    @NotNull(message = "Arrival time is required")
    private Date arrivalTime;

    @NotNull(message = "Aircraft is required")
    private Aircraft aircraft;
}
