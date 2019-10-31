package com.sample.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Map;

public class SampleApplication {

//    private static ApplicationContext app;
//    private static EntityManager manager;
//
//    public static void main(String[] args) {
//        app = new AnnotationConfigApplicationContext(MyAppConfig.class);
//        EntityManagerFactory factory = app.getBean(EntityManagerFactory.class);
//        manager = factory.createEntityManager();
//
//        MyPersonDataDao dao = new MyPersonDataDaoImpl();
//        List<MyPersonData> list = dao.getAllEntity();
//
//        for (MyPersonData person : list) {
//            System.out.println(person);
//        }
//
//        System.out.println("------------");
//
//        list = dao.findByField("name", "hanako");
//        for (MyPersonData person : list) {
//            System.out.println(person);
//        }
//
//        System.out.println("------------");
//
//        dao.addEntity(new MyPersonData("tuyano", "syoda@tuyano.com", 123));
//
//        list = dao.getAllEntity();
//
//        for (MyPersonData person : list) {
//            System.out.println(person);
//        }
//
//        System.out.println("------------");
//
//        MyPersonData personData = manager.find(MyPersonData.class, 1L);
//        personData.setName("**** " + personData.getName() + " *****");
//        dao.updateEntity(personData);
//
//        list = dao.getAllEntity();
//
//        for (MyPersonData person : list) {
//            System.out.println(person);
//        }
//
//        System.out.println("------------");
//        dao.removeEntity(1L);
//
//        list = dao.getAllEntity();
//
//        for (MyPersonData person : list) {
//            System.out.println(person);
//        }
//    }

}
