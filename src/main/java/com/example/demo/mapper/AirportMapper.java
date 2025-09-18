package com.example.demo.mapper;

import com.example.demo.dto.AirportDTO;
import com.example.demo.model.Airport;

public class AirportMapper {

    public static Airport toEntity(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setId(dto.getId());
        airport.setAirportId(dto.getAirportId());
        airport.setAirportName(dto.getAirportName());
        airport.setCity(dto.getCity());
        return airport;
    }

    public static AirportDTO toDTO(Airport entity) {
        AirportDTO dto = new AirportDTO();
        dto.setId(entity.getId());
        dto.setAirportId(entity.getAirportId());
        dto.setAirportName(entity.getAirportName());
        dto.setCity(entity.getCity());
        return dto;
    }
}
