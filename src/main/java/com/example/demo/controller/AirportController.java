package com.example.demo.controller;

import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.services.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService service;


    @GetMapping("/")
    public List<Airport> getAll(){
        return service.getAll();
    }

    @PostMapping("/")
    public Airport add(@RequestBody Airport airport){
        return service.save(airport);
    }
}
