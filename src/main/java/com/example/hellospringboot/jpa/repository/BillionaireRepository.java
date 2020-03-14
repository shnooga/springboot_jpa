package com.example.hellospringboot.jpa.repository;

import com.example.hellospringboot.jpa.entity.BillionaireEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillionaireRepository extends CrudRepository<BillionaireEntity, String> {
    @Query(value = "SELECT * FROM billionaires", nativeQuery = true)
    List<BillionaireEntity> retrieve();
}
