package com.example.demo.controller;

import com.example.demo.dto.FlightDTO;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.model.Aircraft;
import com.example.demo.model.Airport;
import com.example.demo.model.Flight;
import com.example.demo.services.FlightService;
import com.example.demo.repository.AircraftRepository;
import com.example.demo.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;
    private final AirportRepository airportRepository;
    private final AircraftRepository aircraftRepository;

    @GetMapping("/")
    public List<FlightDTO> getAll() {
        return flightService.getAll()
                .stream()
                .map(FlightMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public FlightDTO add(@RequestBody @Valid FlightDTO dto) {
        // Fetch full entities from DB using IDs
        Airport origin = airportRepository.findById(dto.getOrigin().getId())
                .orElseThrow(() -> new RuntimeException("Origin not found"));
        Airport destination = airportRepository.findById(dto.getDestination().getId())
                .orElseThrow(() -> new RuntimeException("Destination not found"));
        Aircraft aircraft = aircraftRepository.findById(dto.getAircraft().getId())
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        // Create Flight entity
        Flight flight = new Flight();
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setAirline(dto.getAirline());
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setAircraft(aircraft);
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());

        // Save
        Flight saved = flightService.save(flight);

        // Map back to DTO
        return FlightMapper.toDTO(saved);
    }
}
