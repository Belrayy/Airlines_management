package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
public class airport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_seq")
    @GenericGenerator(
            name = "airport_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "airport_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

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

    airport() {
    }
    public airport(String airportId, String airportName, String city) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.city = city;
    }
}
