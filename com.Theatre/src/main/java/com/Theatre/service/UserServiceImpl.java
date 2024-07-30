package com.Theatre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Theatre.enities.User;
import com.Theatre.repo.UserRepo;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	
	
	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public User addUser(User u) {
		
		return userRepo.save(u);
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public User updateUser(User u) {
		
		return userRepo.save(u);
	}

	@Override
	public Optional<User> getUtenteById(int id) {
		
		return userRepo.findById(id);
	}

}
