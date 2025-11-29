package com.example.demo.repository;

import com.example.demo.model.Meteo;
import com.example.demo.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@RepositoryRestResource(path = "meteo")
public interface MeteoRepository extends JpaRepository<Meteo, Long> {

    Page<Meteo> findByDateGreaterThanEqualAndLocation(
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Location location,
            Pageable pageable
    );
} 
