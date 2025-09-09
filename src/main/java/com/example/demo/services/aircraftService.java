package com.example.demo.services;


import com.example.demo.classes.aircraft;
import com.example.demo.repository.aircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class aircraftService {

    private final aircraftRepository Repository;

    public aircraftService(aircraftRepository Repository) {
        this.Repository = Repository;
    }

    public List<aircraft> getAll(){
        return Repository.findAll();
    }

    public aircraft save(aircraft aircraft){
        return Repository.save(aircraft);
    }


}
