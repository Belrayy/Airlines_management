package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDTO {

    private Long id;

    @NotBlank(message = "Airport ID is required")
    private String airportId;

    @NotBlank(message = "Airport name is required")
    private String airportName;

    @NotBlank(message = "Airport's city is required")
    private String city;

}
