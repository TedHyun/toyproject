package com.example.main.springboot.web.querydsltest;


import com.example.main.springboot.web.domain.posts.CityRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
@SuppressWarnings({"rawtype", "unchecked"})
public class TestQuerydsl implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TestQuerydsl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String[] args) throws Exception {

    }
}
