package com.example.demo.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
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
public class flight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @GenericGenerator(
            name = "flight_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "flight_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    private Long id;

    @NotBlank(message = "Flight number is required")
    @Column(name = "flightNumber", nullable = false, unique = true)
    private String flightNumber;

    @NotBlank(message = "Airline is required")
    private String airline;

    @NotBlank(message = "Origin of flight is required")
    private String origin;

    @NotBlank(message = "Destination of flight is required")
    private String destination;

    @NotNull(message = "Departure time is required")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

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

    public flight() {}

    public flight(String flightNumber, String airline, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;

    }

}
