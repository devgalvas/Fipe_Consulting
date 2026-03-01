package com.example.alura.tabelafipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface iDataConversor {
    <T> T convertData(String json, Class <T> classe);

    <T> List<T> getList(String json, Class<T> classe) throws JsonProcessingException;
}
