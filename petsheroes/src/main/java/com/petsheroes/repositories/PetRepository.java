package com.petsheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petsheroes.models.Pet;

public interface PetRepository extends JpaRepository <Pet, Long> {

}
