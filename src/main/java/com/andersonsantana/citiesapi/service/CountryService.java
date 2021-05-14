package com.andersonsantana.citiesapi.service;

import com.andersonsantana.citiesapi.entity.countries.Country;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public Page<Country> findPage(Pageable page) {
        return countryRepository.findAll(page);
    }




    public Country findCountryById(Long id) throws ObjectNotFoundException {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Country"));
        return country;
    }
}
