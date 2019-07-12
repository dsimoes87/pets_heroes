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
	
	@GetMapping("/pets/{idPet}")
	public Pet  mostrarPet(@PathVariable(value="idPet") long idPet){
		return petRepository.findById(idPet);
	}
	
	@PostMapping("/pets/{idUser}")
	public String cadPet(@PathVariable(value="idUser") long idUser, @RequestBody Pet pet) {
		User user = userRepository.findById(idUser);
		pet.setUser(user);
		petRepository.save(pet);	
		return "";
	}
	@GetMapping("/pets/lista/{idUser}")
	public Iterable<Pet> petByUser(@PathVariable(value="idUser") long idUser) {
		User user = userRepository.findById(idUser);
		Iterable<Pet> pets = petRepository.findByUser(user);
		return pets;
	}
	@DeleteMapping("/pets/{idPet}")
	public void  deletaPet(@PathVariable(value="idPet") long idPet){
		Pet pet = petRepository.findById(idPet);
		petRepository.delete(pet);
	}
	@PutMapping("/pets/edit/{idPet}")
	public User editPet(@PathVariable(value="idPet") long idPet, @RequestBody Pet petAlter) {
		Pet pet = petRepository.findById(idPet);
		petAlter.setIdPet(pet.getIdPet());
		pet = petAlter;
		petRepository.save(pet);	
		return pet.getUser();
	}
	

}
