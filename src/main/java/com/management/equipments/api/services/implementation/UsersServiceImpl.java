package com.management.equipments.api.services.implementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.dto.mapper.UserMapper;
import com.management.equipments.api.entities.Role;
import com.management.equipments.api.entities.User;
import com.management.equipments.api.repositories.RolesRepository;
import com.management.equipments.api.repositories.UsersRepository;
import com.management.equipments.api.services.UsersService;
import com.management.equipments.api.services.implementation.exceptions.SaveFailException;

@Service("usersDetailsService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private UserMapper mapper = UserMapper.MAPPER;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println("Current User: " + user.toString());
		return user;
	}

	@Override
	public void saveUser(UserDto dto) throws SaveFailException {
		User user = mapper.fromDto(dto);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role adminRole = rolesRepository.findByRole("NORMAL");
		user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
		usersRepository.save(user);
	}
	
	@Override
	public List<UserDto> findAll() {
		return mapper.toDtos(usersRepository.findAll());
	}

	@Override
	public void saveAdminUser(UserDto dto) throws SaveFailException {
		User user = mapper.fromDto(dto);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role adminRole = rolesRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
		usersRepository.save(user);
	}

	@Override
	public UserDto findByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return mapper.toDto(user);
	}
}
