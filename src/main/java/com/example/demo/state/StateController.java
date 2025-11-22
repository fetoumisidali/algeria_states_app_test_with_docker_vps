package com.example.demo.state;

/*
    @Author Fetoumi Sidali
    @Created 11/22/2025
*/

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @JsonView(Views.Full.class)
    @GetMapping
    public ResponseEntity<List<State>> findAll(){
        return ResponseEntity.ok().body(stateService.findAll());
    }

    @JsonView(Views.Arabic.class)
    @GetMapping("/ar")
    public ResponseEntity<List<State>> findAllInArabic(){
        return ResponseEntity.ok().body(stateService.findAll());
    }

    @JsonView(Views.English.class)
    @GetMapping("/en")
    public ResponseEntity<List<State>> findAllInEnglish(){
        return ResponseEntity.ok().body(stateService.findAll());
    }


}
