package com.example.demo.mapper;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.model.Aircraft;

public class AircraftMapper {

    public static Aircraft toEntity(AircraftDTO dto) {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(dto.getId());
        aircraft.setModel(dto.getModel());
        aircraft.setRegistrationNumber(dto.getRegistrationNumber());
        aircraft.setCapacity(dto.getCapacity());
        aircraft.setStatus(dto.getStatus());
        return aircraft;
    }

    public static AircraftDTO toDTO(Aircraft entity) {
        AircraftDTO dto = new AircraftDTO();
        dto.setId(entity.getId());
        dto.setModel(entity.getModel());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setCapacity(entity.getCapacity());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
