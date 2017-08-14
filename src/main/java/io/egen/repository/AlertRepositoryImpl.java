package io.egen.repository;

import io.egen.entity.AlertRecord;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlertRepositoryImpl implements AlertRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void create(AlertRecord ar) {
        entityManager.persist(ar);
    }
}
