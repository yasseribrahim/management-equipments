package com.management.equipments.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.equipments.api.dto.UserDto;
import com.management.equipments.api.dto.mapper.UserMapper;
import com.management.equipments.api.entities.User;
import com.management.equipments.api.repositories.UsersRepository;

@RestController
@RequestMapping(path = "/api/users")
public class ApiUsersController {
	@Autowired
	private UsersRepository repository;

	@PutMapping(path = "/add")
	public @ResponseBody User add(@RequestBody User user) {
		return repository.save(user);
	}

	@PutMapping(path = "/addAll")
	public @ResponseBody Iterable<User> addAll(@RequestBody Iterable<User> users) {
		return repository.save(users);
	}

	@GetMapping(path = "/find/{id}")
	public ResponseEntity<UserDto> find(@PathVariable("id") Long id) {
		User user = null;
		try {
			user = repository.getOne(id);
			return new ResponseEntity<UserDto>(UserMapper.MAPPER.toDto(user), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<UserDto>(UserMapper.MAPPER.toDto(new User()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/list")
	public @ResponseBody Iterable<UserDto> list() {
		return UserMapper.MAPPER.toDtos(repository.findAll());
	}

	@GetMapping(path = "/login")
	public @ResponseBody  ResponseEntity<UserDto>  login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User currentUser = repository.findByUsername(authentication.getName());
			return new ResponseEntity<UserDto>(UserMapper.MAPPER.toDto(currentUser), HttpStatus.OK);
		}
		return new ResponseEntity<UserDto>(UserMapper.MAPPER.toDto(new User()), HttpStatus.FORBIDDEN);
	}
}
