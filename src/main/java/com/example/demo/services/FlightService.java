package com.example.demo.services;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository Repository;

    public List<Flight> getAll(){
        return Repository.findAll();
    }

    public Flight save(Flight flight){
        return Repository.save(flight);
    }
}
