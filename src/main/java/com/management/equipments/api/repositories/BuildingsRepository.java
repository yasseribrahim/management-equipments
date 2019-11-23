package com.management.equipments.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.equipments.api.entities.Building;

public interface BuildingsRepository extends JpaRepository<Building, Long> {
	Building findByName(String name);

	Building findByCode(String code);
}
