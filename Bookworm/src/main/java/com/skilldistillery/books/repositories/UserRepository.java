package com.skilldistillery.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.books.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	

}
