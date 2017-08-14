package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll",
                Reading.class);
        return query.getResultList();
    }

    public Reading findByVin(String vin) {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findByVin",
                Reading.class);
        query.setParameter("paramVin", vin);
        List<Reading> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public Reading create(Reading r) {
        entityManager.persist(r);
        return r;
    }

    public Reading update(Reading r) {
        return entityManager.merge(r);
    }
}
