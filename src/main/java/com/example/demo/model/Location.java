package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity 
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Meteo> meteoList;

    public Location() {}

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
