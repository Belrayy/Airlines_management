package com.example.demo.controller;

import com.example.demo.model.Aircraft;
import com.example.demo.services.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private AircraftService service;

    public AircraftController(AircraftService service){
        this.service = service;
    }

    @GetMapping
    public List<Aircraft> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Aircraft save(@RequestBody Aircraft aircraft){
        return service.save(aircraft);
    }
}
