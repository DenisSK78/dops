package com.dops.dops;

import com.dops.dops.dao.City;
import com.dops.dops.dao.CityRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DopsApplicationTests {

    Logger logger = LoggerFactory.getLogger(DopsApplicationTests.class);

    @Autowired
    CityRepository repository;


    @Test
    void contextLoads() {
        List<City> cities = repository.findAll();
        cities.forEach(e -> logger.info(e.toString()));
    }

}
