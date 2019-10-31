package com.sample.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPersonDataDaoRepository extends JpaRepository<MyPersonData, Integer> {
}
