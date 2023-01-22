package com.skilldistillery.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.books.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByUsernameAndPassword(String username, String password);


}
