package com.dops.dops.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CityRepository extends JpaRepository<City, Long> {
}
