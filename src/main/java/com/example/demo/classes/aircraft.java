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
        name="aircrafts",
        uniqueConstraints=@UniqueConstraint(
                name="uc_aircraft_registration",
                columnNames = {"registrationNumber"}
        )

)
@Getter
@Setter
public class aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_seq")
    @GenericGenerator(
            name = "aircraft_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "aircraft_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    private Long id;

    @Column(name="aircraft_model", nullable=false, length=50)
    @NotBlank(message="Model is required")
    private String model;

    @Column(name="registration_number", nullable=false , unique=true , length=20)
    @NotBlank(message="Registration number is required")
    private String registrationNumber;

    @Column(nullable = false)
    @NotNull(message= "Capacity is required")
    @Positive(message= "Capacity must be positive")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false , length=20)
    private AircraftStatus status;

    @Version
    private Long Version;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    public aircraft() {}

    public aircraft(String model,String registrationNumber, Integer capacity, AircraftStatus status ) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.status = status;
    }


}

enum AircraftStatus {
    ACTIVE,
    INACTIVE
}
