package com.sample.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class MyPersonDataDaoImpl extends AbstractMyPersonDataDao {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private LocalContainerEntityManagerFactoryBean factory;

    @PersistenceContext
    private EntityManager manager;

    public MyPersonDataDaoImpl() {
        init();
    }

    @Override
    public List<MyPersonData> getAllEntity() {
        Query query = manager.createQuery("from MyPersonData");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<MyPersonData> findByField(String field, String find) {
        Query query = manager.createQuery("from MyPersonData where " + field + " = '" +  find + "'");
        return query.getResultList();
    }


    public void addEntity(MyPersonData entity) {
        EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(entity);
        manager.flush();
        transaction.commit();
    }

    public void updateEntity(MyPersonData entity) {
        EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(entity);
        manager.flush();
        transaction.commit();
    }

    public void removeEntity(MyPersonData data) {
        EntityManager manager = factory.getNativeEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.remove(data);
        manager.flush();
        transaction.commit();
    }

    @Override
    public void removeEntity(Long id) {
        MyPersonData entity = (MyPersonData) manager.find(com.sample.sample.MyPersonData.class, id);
        removeEntity(entity);
    }
}
