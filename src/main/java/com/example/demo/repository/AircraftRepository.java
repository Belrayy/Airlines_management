package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.demo.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft,Long> {

    //find by reg number
    Optional<Aircraft> findByRegistrationNumber(String registrationNumber);
    boolean existsByRegistrationNumber(String registrationNumber);

}
