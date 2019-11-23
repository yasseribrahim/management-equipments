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

import com.management.equipments.api.dto.EquipmetDto;
import com.management.equipments.api.services.EquipmentsService;
import com.management.equipments.api.util.CustomErrorType;

@RestController
@RequestMapping(path = "/api/equipmets")
public class EquipmetsController {
	public static final Logger LOGGER = LoggerFactory.getLogger(EquipmetsController.class);

	@Autowired
	private EquipmentsService equipmetsService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/list")
	public ResponseEntity<List<EquipmetDto>> list() {
		List<EquipmetDto> products = equipmetsService.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<EquipmetDto>>(products, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") long id) {
		LOGGER.info("Fetching Product with id {}", id);
		EquipmetDto dto = equipmetsService.findById(id);
		if (dto == null) {
			LOGGER.error("Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Product with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EquipmetDto>(dto, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody EquipmetDto dto) {
		LOGGER.info("Creating Product : {}", dto);

		if (equipmetsService.isExist(dto)) {
			LOGGER.error("Unable to create. A Product with name {} already exist", dto.getName());
			return new ResponseEntity(
					new CustomErrorType("Unable to create. A Product with name " + dto.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		dto = equipmetsService.save(dto);

		return new ResponseEntity<EquipmetDto>(dto, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody EquipmetDto dto) {
		LOGGER.info("Updating Product with id {}", id);

		EquipmetDto currentProductDto = equipmetsService.findById(id);

		if (currentProductDto == null) {
			LOGGER.error("Unable to update. Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Product with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentProductDto = equipmetsService.update(currentProductDto);
		return new ResponseEntity<EquipmetDto>(currentProductDto, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		LOGGER.info("Fetching & Deleting Product with id {}", id);

		EquipmetDto dto = equipmetsService.findById(id);
		if (dto == null) {
			LOGGER.error("Unable to delete. Product with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Product with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		boolean result = equipmetsService.deleteById(id);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	@DeleteMapping(value = "/clear")
	public ResponseEntity<Boolean> deleteAllProducts() {
		LOGGER.info("Deleting All Products");
		boolean result = equipmetsService.deleteAll();
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
