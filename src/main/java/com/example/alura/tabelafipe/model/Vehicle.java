package com.example.alura.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle (
        @JsonAlias("price") String value,
        @JsonAlias("modelYear") Integer modelYear,
        @JsonAlias("brand") String brand,
        @JsonAlias("fuel") String fuelType,
        @JsonAlias("model") String model
) {
}
