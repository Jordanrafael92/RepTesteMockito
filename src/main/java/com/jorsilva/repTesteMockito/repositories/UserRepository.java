package com.jorsilva.repTesteMockito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorsilva.repTesteMockito.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
