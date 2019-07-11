package com.petsheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petsheroes.models.Pet;
import com.petsheroes.models.User;

public interface PetRepository extends JpaRepository <Pet, Long> {
	Pet findById(long idPet);
	Iterable<Pet> findByUser(User user);
}
