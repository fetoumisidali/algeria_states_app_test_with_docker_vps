package com.example.demo.state;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/*
    @Author Fetoumi Sidali
    @Created 11/22/2025
*/
public record State (

        @JsonView(Views.Base.class)
        int id,

        @JsonView(Views.Base.class)
        String code,

        @JsonView(Views.English.class)
        String name,

        @JsonProperty("ar_name")
        @JsonView(Views.Arabic.class)
        String arabicName
) {
}
