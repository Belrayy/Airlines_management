package com.example.demo.controller;

import com.example.demo.dto.AirportDTO;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.model.Airport;
import com.example.demo.services.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/airport")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService service;

    @GetMapping("/")
    public List<AirportDTO> getAll() {
        return service.getAll()
                .stream()
                .map(AirportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public AirportDTO add(@RequestBody @Valid AirportDTO dto) {
        Airport airport = AirportMapper.toEntity(dto);
        Airport saved = service.save(airport);
        return AirportMapper.toDTO(saved);
    }
}
