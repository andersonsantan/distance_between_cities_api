package com.andersonsantana.citiesapi.resource;

import com.andersonsantana.citiesapi.entity.cities.City;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/cities")
public class CityResource {

    CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public Page<City> citiesAll(Pageable pageable){
        return cityService.findPage(pageable);
    }

    @GetMapping(path = "/{id}")
    public City cityOne(@PathVariable Long id) throws ObjectNotFoundException {
        return cityService.findCityById(id);
    }


}
