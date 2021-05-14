package com.andersonsantana.citiesapi.service;

import com.andersonsantana.citiesapi.entity.states.State;
import com.andersonsantana.citiesapi.exception.ObjectNotFoundException;
import com.andersonsantana.citiesapi.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }


   public Page<State> findPage(Pageable page) {
        return stateRepository.findAll(page);
    }


    public State findStateById(Long id) throws ObjectNotFoundException {
        return stateRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "State"));
    }
}
