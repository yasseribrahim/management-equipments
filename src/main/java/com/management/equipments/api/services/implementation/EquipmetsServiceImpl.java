package com.management.equipments.api.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.equipments.api.dto.EquipmetDto;
import com.management.equipments.api.dto.mapper.EquipmetMapper;
import com.management.equipments.api.entities.Equipment;
import com.management.equipments.api.repositories.EquipmentsRepository;
import com.management.equipments.api.services.EquipmentsService;

@Service("equipmetsService")
@Transactional
public class EquipmetsServiceImpl implements EquipmentsService {

	@Autowired
	private EquipmentsRepository repository;

	private EquipmetMapper mapper = EquipmetMapper.MAPPER;

	@Override
	public EquipmetDto findById(Long id) {
		Equipment product = repository.findOne(id);
		if (product != null) {
			return mapper.toDto(product);
		}
		return null;
	}
	

	@Override
	public EquipmetDto findByName(String name) {
		Equipment product = repository.findByName(name);
		if (product != null) {
			return mapper.toDto(product);
		}
		return null;
	}

	@Override
	public EquipmetDto save(EquipmetDto dto) {
		Equipment product = repository.findOne(dto.getId());
		if (product == null) {
			product = mapper.fromDto(dto);
		} else {
			product.setName(dto.getName());
			product.setNote(dto.getNote());
		}
		product = repository.save(mapper.fromDto(dto));

		return mapper.toDto(product);
	}

	@Override
	public EquipmetDto update(EquipmetDto product) {
		return save(product);
	}

	@Override
	public boolean deleteById(Long id) {
		repository.delete(id);
		return true;
	}

	@Override
	public boolean deleteAll() {
		repository.deleteAll();
		return true;
	}

	@Override
	public List<EquipmetDto> findAll() {
		return mapper.toDtos(repository.findAll());
	}

	@Override
	public boolean isExist(EquipmetDto product) {
		return findByName(product.getName()) != null;
	}
}
