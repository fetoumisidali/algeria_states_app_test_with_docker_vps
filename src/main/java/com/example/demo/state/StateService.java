package com.example.demo.state;

/*
    @Author Fetoumi Sidali
    @Created 11/22/2025
*/

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateDataLoader stateDataLoader;

    public StateService(StateDataLoader stateDataLoader) {
        this.stateDataLoader = stateDataLoader;
    }

    List<State> findAll(){
        return stateDataLoader.getStates();
    }
}
