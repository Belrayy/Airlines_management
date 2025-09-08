package com.example.demo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(
        name="aircrafts",
        uniqueConstraints=@UniqueContraint(
                name="uc_aircraft_registration",
                columnNames = {"registrationNumber"}
        )

)
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

    @Column(name="aircraft_model", nullable="false", length="50")
    @NotBlank(message="Model is required")
    private String model;

    @Column(name="registration_number", nullable="false", unique="true", length="20")

}
