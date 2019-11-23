package com.management.equipments.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.equipments.api.entities.Equipment;

public interface EquipmentsRepository extends JpaRepository<Equipment, Long> {
	Equipment findByName(String name);
}
