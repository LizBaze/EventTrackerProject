package com.skilldistillery.books.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.books.entities.User;
import com.skilldistillery.books.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("users")
	public List<User> findAll() {
		return userServ.findAll();
	}
	
	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id, HttpServletResponse resp) {
		
		User user = userServ.getUser(id);
		if(user == null) {
			resp.setStatus(404);
		}
		return user;
	}
	
	@PostMapping("users")
	public User createUser(@RequestBody User user, HttpServletResponse resp) {
		if (userServ.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null) {
			user = userServ.createUser(user);
		} else {
			user = null;
			resp.setStatus(400);
		}
		
		return user;
	}
	
	@PutMapping("users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id, HttpServletResponse resp) {
		
		user = userServ.updateUser(user, id);
		if(user == null) {
			resp.setStatus(404);
		}
		
		return user;
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id, HttpServletResponse resp) {
		
		if (userServ.deleteUser(id)) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
		
	}
	
	

}
