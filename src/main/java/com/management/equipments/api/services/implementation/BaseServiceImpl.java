package com.management.equipments.api.services.implementation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.security.core.context.SecurityContextHolder;

import com.management.equipments.api.entities.User;

public abstract class BaseServiceImpl {
	protected User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	protected Date getNow() {
		return Calendar.getInstance().getTime();
	}
}
