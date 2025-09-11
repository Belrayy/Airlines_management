package com.example.demo.services;


import com.example.demo.model.Aircraft;
import com.example.demo.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftService {

    private final AircraftRepository Repository;

    public List<Aircraft> getAll(){
        return Repository.findAll();
    }

    public Aircraft save(Aircraft aircraft){
        return Repository.save(aircraft);
    }


}
