package com.example.demo.services;

import com.example.demo.model.Airport;
import com.example.demo.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository Repository;


    public List<Airport> getAll(){
        return Repository.findAll();
    }

    public Airport save(Airport airport){
        return Repository.save(airport);
    }
}
