package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@Table(
        name="flight",
        uniqueConstraints=@UniqueConstraint(
                name="uc_flight_registration",
                columnNames = {"flightNumber"}
        )

)
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Flight number is required")
    @Column(name = "FLIGHTNUMBER", nullable = false, unique = true)
    private String flightNumber;

    @NotBlank(message = "Airline is required")
    private String airline;

    @NotBlank(message = "Origin of flight is required")
    private String origin;

    @NotBlank(message = "Destination of flight is required")
    private String destination;

    @Column(name = "DEPARTURETIME")
    @NotNull(message = "Departure time is required")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    @Column(name = "ARRIVALTIME")
    @NotNull(message = "Arrival time is required")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    @Positive(message = "Capacity must be positive")
    private Integer capacity;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Flight() {}

    public Flight(String flightNumber, String airline, String origin, String destination, Date departureTime, Date arrivalTime, Integer capacity) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
    }


}
