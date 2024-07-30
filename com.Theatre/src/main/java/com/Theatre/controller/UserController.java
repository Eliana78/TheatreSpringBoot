package com.Theatre.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Theatre.enities.User;
import com.Theatre.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/users")
	@CrossOrigin
	public List<User> getAllUser(){
		return userService.getAllUser();
	};
	
	@PostMapping("/users/add")
	@CrossOrigin
	public User addUser(@RequestBody User u) {
		return userService.addUser(u);
	};
	
	
	@DeleteMapping("/users/delete/{id}")
	@CrossOrigin
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	};
	
	
	@PutMapping("/user/update")
	@CrossOrigin
	public User updateUser(@RequestBody User u) {
		return userService.updateUser(u);
	};
	
	
	
	@GetMapping("/user/id/{id}")
	@CrossOrigin
	public ResponseEntity <User> getUtenteById(@PathVariable int id){
		Optional<User> userOptional=userService.getUtenteById(id);
		
		if(userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	};
	
	
	
}
