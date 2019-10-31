package com.sample.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyPersonDataDaoRepository extends JpaRepository<MyPersonData, Integer> {
    public List<MyPersonData> findByName(String name);
    public List<MyPersonData> findByMail(String mail);
    public List<MyPersonData> findByAge(int age);
    public List<MyPersonData> findByNameLike(String name);
    public List<MyPersonData> findByMailLike(String mail);
    public List<MyPersonData> findByNameOrMail(String name, String mail);
    public List<MyPersonData> findByNameLikeOrMailLike(String name, String mail);
    public List<MyPersonData> findByAgeGreaterThan(Integer age);
    public List<MyPersonData> findByAgeLessThan(Integer age);
    public List<MyPersonData> findByAgeGreaterThanOrAgeLessThan(Integer age0, Integer age1);
    @Query("select name from MyPersonData")
    public List<String> getAllName();
}
