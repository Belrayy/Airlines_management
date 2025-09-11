package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.services.AircraftService;
import com.example.demo.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService service;

    @GetMapping
    public List<Flight> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight){
        return service.save(flight);
    }
}
