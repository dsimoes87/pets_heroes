package com.petsheroes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petsheroes.models.Pet;
import com.petsheroes.models.User;
import com.petsheroes.repositories.PetRepository;
import com.petsheroes.repositories.UserRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PetController {
	
	@Autowired
	PetRepository petRepository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/pets")
	public List<Pet> findAllPets(){
		return petRepository.findAll();
	}
	@PostMapping("/pets/{idUser}")
	public String cadPet(@PathVariable(value="idUser") long idUser, @RequestBody Pet pet) {
		User user = userRepository.findById(idUser);
		pet.setUser(user);
		petRepository.save(pet);	
		return "";
	}
	
	

}
