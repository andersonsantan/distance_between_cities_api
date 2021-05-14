package com.andersonsantana.citiesapi.service;

import com.andersonsantana.citiesapi.entity.cities.City;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CityService {

    CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public Page<City> findPage(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }


    public City findCityById(Long id) throws ObjectNotFoundException {
        return cityRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "City"));
    }
}
