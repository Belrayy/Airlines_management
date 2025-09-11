package com.example.demo.model;

import com.example.demo.model.enums.AircraftStatus;
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
        name="aircrafts",
        uniqueConstraints=@UniqueConstraint(
                name="uc_aircraft_registration",
                columnNames = {"registrationNumber"}
        )

)
@Getter
@Setter
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Aircraft() {}

    public Aircraft(String model,String registrationNumber, Integer capacity, AircraftStatus status ) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.status = status;
    }


}

