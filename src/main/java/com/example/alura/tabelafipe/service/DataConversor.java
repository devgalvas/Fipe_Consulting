package com.example.alura.tabelafipe.service;

import com.fasterxml.jackson.core.JsonProcessingException; // Ajustado
import com.fasterxml.jackson.databind.ObjectMapper;       // Ajustado
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class DataConversor implements iDataConversor {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertData(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch(JsonProcessingException e) { // Ajustado para a versão estável
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> classe) throws JsonProcessingException {
        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);

        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}