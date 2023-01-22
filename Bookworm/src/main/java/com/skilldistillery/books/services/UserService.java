package com.skilldistillery.books.services;

import java.util.List;

import com.skilldistillery.books.entities.User;

public interface UserService {
	List<User> findAll();
	User getUser(int id);
	User createUser(User user);
	User updateUser(User user, int id);
	boolean deleteUser(int id);
	User findByUsernameAndPassword(String username, String password);

}
