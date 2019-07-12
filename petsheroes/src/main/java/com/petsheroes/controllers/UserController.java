package com.petsheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petsheroes.models.User;
import com.petsheroes.repositories.UserRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping("/user/{idUser}")
	public User findOneUser(@PathVariable(value="idUser") long idUser){
		return userRepository.findById(idUser);
	}
	@PostMapping("/user")
	public User sendUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	@PutMapping("/user")
	public User alterUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	@DeleteMapping("/user/{idUser}")
	public boolean deleteUser(@PathVariable(value="idUser") long idUser) {
		User user = userRepository.findById(idUser);
		userRepository.delete(user);
		return true;	
	}
	@PostMapping("/user/login")
	public long loginUser(@RequestBody User userlogin) {
		User user = userRepository.findByEmailUser(userlogin.getEmailUser());
		if(user == null) {
			throw new RuntimeException ("User error");
		}
		if(!user.getSenha().equals(userlogin.getSenha())) {
			throw new RuntimeException ("Password error");
		}
		return (user.getIdUser());
		
	}
	@PutMapping("/user/edit/{idUser}")
	public User editUser(@PathVariable(value="idUser") long idUser,@RequestBody User userAlter) {
		User user = userRepository.findById(idUser);
		userAlter.setIdUser(user.getIdUser());
		user = userAlter;
		return userRepository.save(user);
		
		
	}
		
}
