package com.management.equipments.api.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.equipments.api.dto.BuildingDto;
import com.management.equipments.api.dto.mapper.BuildingMapper;
import com.management.equipments.api.entities.Building;
import com.management.equipments.api.entities.User;
import com.management.equipments.api.repositories.BuildingsRepository;
import com.management.equipments.api.services.BuildingsService;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;;

@Service("buildinsService")
@Transactional
public class BuildingsServiceImpl extends BaseServiceImpl implements BuildingsService {

	@Autowired
	private BuildingsRepository repository;

	private BuildingMapper mapper = BuildingMapper.MAPPER;

	@Override
	public BuildingDto findById(Long id) {
		Building building = repository.findOne(id);
		if (building != null) {
			return mapper.toDto(building);
		}
		return null;
	}

	@Override
	public BuildingDto findByCode(String code) {
		Building building = repository.findByCode(code);
		if (building != null) {
			return mapper.toDto(building);
		}
		return null;
	}

	@Override
	public BuildingDto findByName(String name) {
		Building building = repository.findByName(name);
		if (building != null) {
			return mapper.toDto(building);
		}
		return null;
	}

	@Override
	public BuildingDto save(BuildingDto dto) throws SaveFailException {
		Building building = (dto.getId() != null) ? repository.findOne(dto.getId()) : null;
		User currentUser = getCurrentUser();
		try {
			if (building == null) {
				building = mapper.fromDto(dto);
				building.setCreatedBy(currentUser.getId());
				building.setCreatedDate(getNow());
				building.setModifiedBy(currentUser.getId());
				building.setModifiedDate(getNow());
			} else {
				building.setName(dto.getName());
				building.setNote(dto.getNote());
				building.setModifiedBy(currentUser.getId());
				building.setModifiedDate(getNow());
			}
			building = repository.save(building);

			return mapper.toDto(building);
		} catch (Exception e) {
			throw new SaveFailException(getClass().getName() + ".save(" + dto + ")" + e.getMessage(), e.getCause());
		}
	}

	@Override
	public BuildingDto update(BuildingDto product) throws SaveFailException {
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
	public List<BuildingDto> findAll() {
		return mapper.toDtos(repository.findAll());
	}

	@Override
	public boolean isExist(BuildingDto product) {
		return findByName(product.getName()) != null;
	}
}
