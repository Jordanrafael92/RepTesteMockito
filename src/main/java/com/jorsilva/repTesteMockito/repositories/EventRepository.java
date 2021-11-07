package com.jorsilva.repTesteMockito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorsilva.repTesteMockito.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}

