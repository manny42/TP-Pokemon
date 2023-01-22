package com.micro.service.h2demo;

import com.micro.service.h2demo.model.City;
import com.micro.service.h2demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }
}