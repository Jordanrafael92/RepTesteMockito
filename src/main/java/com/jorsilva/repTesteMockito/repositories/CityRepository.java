package com.jorsilva.repTesteMockito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorsilva.repTesteMockito.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
