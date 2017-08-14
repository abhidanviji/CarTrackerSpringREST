package io.egen.service;

import io.egen.entity.Vehicles;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicles> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicles findOne(String vin) {
        Vehicles existing =  repository.findByVin(vin);
        if(existing == null){
            throw new ResourceNotFoundException("Vehicle with VIN "+vin+" does not exist");
        }
        return existing;
    }

    @Transactional
    public Vehicles update(List<Vehicles> v) {
        for(Vehicles e: v) {
            Vehicles existing = repository.findByVin(e.getVin());
            if (existing == null) {
                repository.create(e);
            }else {
                repository.update(e);
            }
        }
        return null;
    }

}
