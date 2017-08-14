package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicles;

import java.util.List;

public interface ReadingRepository {
    List<Reading> findAll();

    Reading findByVin(String vin);

    Reading create(Reading emp);

    Reading update(Reading emp);
}
