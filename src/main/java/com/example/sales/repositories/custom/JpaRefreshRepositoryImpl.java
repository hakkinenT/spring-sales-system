package com.example.sales.repositories.custom;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JpaRefreshRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JpaRefreshRepository<T, ID> {

    private final EntityManager entityManager;

    public JpaRefreshRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public void refresh(T t){
        entityManager.refresh(t);

    }
}
