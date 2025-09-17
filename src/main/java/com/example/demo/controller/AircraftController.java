package com.example.demo.controller;

import com.example.demo.model.Aircraft;
import com.example.demo.services.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/aircraft")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService service;

    @GetMapping("/")
    public List<Aircraft> getAll(){
        return service.getAll();
    }

    @PostMapping("/")
    public Aircraft save(@RequestBody Aircraft aircraft){
        return service.save(aircraft);
    }
}
