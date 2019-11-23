package com.management.equipments.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.equipments.api.dto.BuildingDto;
import com.management.equipments.api.services.BuildingsService;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;
import com.management.equipments.api.util.CustomErrorType;

@RestController
@RequestMapping(path = "/api/buildings")
public class BuildinsController {
	public static final Logger LOGGER = LoggerFactory.getLogger(BuildinsController.class);

	@Autowired
	private BuildingsService service;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/list")
	public ResponseEntity<List<BuildingDto>> list() {
		List<BuildingDto> list = service.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<BuildingDto>>(list, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<?> getBuilding(@PathVariable("id") long id) {
		LOGGER.info("Fetching Product with id {}", id);
		BuildingDto dto = service.findById(id);
		if (dto == null) {
			LOGGER.error("Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Product with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BuildingDto>(dto, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody BuildingDto dto) {
		LOGGER.info("Creating Product : {}", dto);

		if (service.isExist(dto)) {
			LOGGER.error("Unable to create. A Product with name {} already exist", dto.getName());
			return new ResponseEntity(
					new CustomErrorType("Unable to create. A Product with name " + dto.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		try {
			dto = service.save(dto);
		} catch (SaveFailException e) {
			// TODO: handle exception
		}

		return new ResponseEntity<BuildingDto>(dto, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody BuildingDto dto) {
		LOGGER.info("Updating Product with id {}", id);

		BuildingDto currentBuildingDto = service.findById(id);

		if (currentBuildingDto == null) {
			LOGGER.error("Unable to update. Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Product with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		try {
			currentBuildingDto = service.update(currentBuildingDto);
		} catch (SaveFailException e) {
			// TODO: handle exception
		}

		return new ResponseEntity<BuildingDto>(currentBuildingDto, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		LOGGER.info("Fetching & Deleting Product with id {}", id);

		BuildingDto dto = service.findById(id);
		if (dto == null) {
			LOGGER.error("Unable to delete. Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		boolean result = service.deleteById(id);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@DeleteMapping(value = "/clear")
	public ResponseEntity<Boolean> deleteAllBuildings() {
		LOGGER.info("Deleting All Products");
		boolean result = service.deleteAll();
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
