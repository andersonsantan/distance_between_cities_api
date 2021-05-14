package com.andersonsantana.citiesapi.resource;

import com.andersonsantana.citiesapi.entity.states.State;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.service.StateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1//state")
public class StateResource {

    StateService stateService;

    public StateResource(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public Page<State> statiesForPage(Pageable page){
        return stateService.findPage(page);
    }
    @GetMapping(path = "/{id}")
    public State stateOne(@PathVariable Long id) throws ObjectNotFoundException {
        return stateService.findStateById(id);
    }
}
