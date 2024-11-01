package com.example.sales.repositories.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoRepositoryBean
public interface JpaRefreshRepository<T, ID> extends JpaRepository<T, ID> {
    void refresh(T t);

    default T saveAndRefresh(T t){
        t = saveAndFlush(t);
        refresh(t);

        return t;
    }
}
