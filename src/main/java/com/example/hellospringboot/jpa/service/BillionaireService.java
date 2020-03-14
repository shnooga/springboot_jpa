package com.example.hellospringboot.jpa.service;


import com.example.hellospringboot.jpa.entity.BillionaireEntity;
import com.example.hellospringboot.jpa.repository.BillionaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillionaireService {
    private final BillionaireRepository repository;

    public BillionaireService(BillionaireRepository repository) {
        this.repository = repository;
    }

    public Optional<List<BillionaireEntity>> retrieve (String zip){
        List<BillionaireEntity> entities = repository.retrieve();
        return Optional.ofNullable(entities);
    }
}