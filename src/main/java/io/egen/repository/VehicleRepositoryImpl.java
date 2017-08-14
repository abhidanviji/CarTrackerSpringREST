package io.egen.repository;

import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicles> findAll() {
        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findAll",
                Vehicles.class);
        return query.getResultList();
    }

    public Vehicles findByVin(String vin) {

        TypedQuery<Vehicles> query = entityManager.createNamedQuery("Vehicles.findByVin",
                Vehicles.class);
        query.setParameter("paramVin", vin);
        List<Vehicles> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public Vehicles create(Vehicles v) {
        entityManager.persist(v);
        return v;
    }

    public Vehicles update(Vehicles v) {
        return entityManager.merge(v);
    }
}
