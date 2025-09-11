package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.demo.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

    Optional<Flight> findByFlightNumber(String registrationNumber);
    boolean existsByFlightNumber(String registrationNumber);

}
