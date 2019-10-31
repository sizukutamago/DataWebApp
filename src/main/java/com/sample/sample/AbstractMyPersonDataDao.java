package com.sample.sample;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;

public class AbstractMyPersonDataDao<T> implements MyPersonDataDao<T> {
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public List<T> getAllEntity() {
        return null;
    }

    @Override
    public List<T> findByField(String field, String find) {
        return null;
    }

    @Override
    public void addEntity(T entity) {

    }

    @Override
    public void updateEntity(T entity) {

    }

    @Override
    public void removeEntity(T data) {

    }

    @Override
    public void removeEntity(Long id) {

    }
}
