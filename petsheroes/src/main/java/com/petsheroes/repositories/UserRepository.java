package com.petsheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petsheroes.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long idUser);
}
