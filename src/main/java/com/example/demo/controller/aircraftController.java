package com.example.demo.controller;

import com.example.demo.classes.aircraft;
import com.example.demo.services.aircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/aircraft")
public class aircraftController {

    private aircraftService service;

    public aircraftController(aircraftService service){
        this.service = service;
    }

    @GetMapping
    public List<aircraft> getAll(){
        return service.getAll();
    }

    @PostMapping
    public aircraft save(@RequestBody aircraft aircraft){
        return service.save(aircraft);
    }
}
