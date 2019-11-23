package com.management.equipments.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.equipments.api.entities.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
