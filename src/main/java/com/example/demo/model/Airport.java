package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name="airport",
        uniqueConstraints=@UniqueConstraint(
                name="uc_airport_registration",
                columnNames = {"airportName"}
        )

)
@Getter
@Setter
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Airport ID is required")
    @Size(min = 3, max = 3, message = "Airport id must be exactly 3 characters long")
    @Column(length = 3, nullable = false, unique = true)
    private String airportId;

    @NotBlank(message = "Airport name is required")
    @Column(nullable = false, unique = true)
    private String airportName;

    @NotBlank(message = "Airport's city is required")
    @Column(nullable = false)
    private String city;

    public Airport() {}
    public Airport(String airportId, String airportName, String city) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.city = city;
    }
}
