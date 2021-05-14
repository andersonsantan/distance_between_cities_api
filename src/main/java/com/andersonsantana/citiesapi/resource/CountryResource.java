package com.andersonsantana.citiesapi.resource;

import com.andersonsantana.citiesapi.entity.countries.Country;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/countries")
public class CountryResource {


    private CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<Country> countriesPages(Pageable page) {
        return countryService.findPage(page);
    }


    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public Country contryOne(@PathVariable Long id) throws ObjectNotFoundException {
        return countryService.findCountryById(id);
    }
}
