package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.demo.classes.aircraft;

public interface aircraftRepository extends JpaRepository<aircraft,Long> {

    //find by reg number
    Optional<aircraft> findByregistrationNumber(String registrationNumber);
    boolean existsByregistrationNumber(String registrationNumber);

}
