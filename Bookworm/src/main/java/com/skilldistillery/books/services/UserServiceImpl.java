package com.skilldistillery.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.books.entities.User;
import com.skilldistillery.books.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		User user = null;
		if(userOpt.isPresent()) {
			user = userOpt.get();
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		if (user.getUsername() != null && user.getPassword() != null) {
			userRepo.saveAndFlush(user);
		} else {
			user = null;
		}
		return user;
	}

	@Override
	public User updateUser(User user, int id) {
		Optional<User> userOpt = userRepo.findById(id);
		User updated = null;
		if(userOpt.isPresent()) {
			updated = userOpt.get();
			updated.setUsername(user.getUsername());
			updated.setPassword(user.getPassword());
		}
		return updated;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean deleted = false;
		Optional<User> userOpt = userRepo.findById(id);
		User user = null;
		if (userOpt.isPresent()) {
			user = userOpt.get();
			//TODO Resolve inevitable foreign key constraint due to followers
			userRepo.delete(user);
			deleted = true;
		}
		
		
		return false;
	}

}
