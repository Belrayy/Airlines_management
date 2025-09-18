package com.example.demo.mapper;

import com.example.demo.dto.FlightDTO;
import com.example.demo.model.Flight;

public class FlightMapper {

    public static FlightDTO toDTO(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setId(flight.getId());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setAirline(flight.getAirline());
        dto.setOrigin(flight.getOrigin());
        dto.setDestination(flight.getDestination());
        dto.setAircraft(flight.getAircraft());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());
        return dto;
    }
}
