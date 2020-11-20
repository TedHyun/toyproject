package com.example.main.springboot.web.domain.posts;

import com.example.main.springboot.web.querydsltest.City;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long>, QuerydslPredicateExecutor<City> {

}
