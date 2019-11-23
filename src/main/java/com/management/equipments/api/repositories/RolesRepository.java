package com.management.equipments.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.equipments.api.entities.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
	Role findByRole(String name);
}
