package io.egen.service;

import io.egen.entity.Reading;

import java.util.List;

public interface ReadingService {
    List<Reading> findAll();
    Reading findOne(String vin);
    void insert(String vin);
    Reading create(Reading r);
}
