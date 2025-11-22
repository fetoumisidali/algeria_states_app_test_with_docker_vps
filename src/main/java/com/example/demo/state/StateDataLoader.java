package com.example.demo.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

/*
    @Author Fetoumi Sidali
    @Created 11/22/2025
*/

@Component
public class StateDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StateDataLoader.class);

    private static final String STATES_DATA_PATH = "classpath:/data/states.json";

    private final JsonMapper jsonMapper;
    private final ResourceLoader resourceLoader;
    private List<State> states;

    public StateDataLoader(JsonMapper jsonMapper, ResourceLoader resourceLoader) {
        this.jsonMapper = jsonMapper;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Started................");

        try{
           Resource resource = resourceLoader.getResource(STATES_DATA_PATH);
           if(!resource.exists()){
               log.warn("data don't exists !");
               return;
           }
           this.states = jsonMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
        }catch (JacksonException e){
            log.warn("something wrong {}",e.getMessage());
        }

        log.info("Loading Completed................");
    }

    public List<State> getStates() {
        return states;
    }
}
