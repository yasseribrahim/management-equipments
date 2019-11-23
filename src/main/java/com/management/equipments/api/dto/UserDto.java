package com.management.equipments.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDto {
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("username")
	@Expose
	private boolean enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", username=" + username + "]";
	}
}
