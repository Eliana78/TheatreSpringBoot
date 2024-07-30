package com.Theatre.service;

import java.util.List;
import java.util.Optional;

import com.Theatre.enities.User;


public interface UserService {

	
	List<User> getAllUser();
	User addUser(User u);
	void deleteUser(int id);
	User updateUser(User u);
	Optional<User> getUtenteById(int id);
	
	
	
}
