package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Airport;

public interface AirportRepository extends JpaRepository<Airport,Long>{

    Optional<Airport> findByairportId(String airportId);
    boolean existsByairportId(String airportId);


}
