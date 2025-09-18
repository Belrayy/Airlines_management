package com.example.demo.controller;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.mapper.AircraftMapper;
import com.example.demo.model.Aircraft;
import com.example.demo.services.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/aircraft")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService service;

    @GetMapping("/")
    public List<AircraftDTO> getAll() {
        return service.getAll()
                .stream()
                .map(AircraftMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public AircraftDTO save(@RequestBody @Valid AircraftDTO dto) {
        Aircraft entity = AircraftMapper.toEntity(dto);
        Aircraft saved = service.save(entity);
        return AircraftMapper.toDTO(saved);
    }
}
