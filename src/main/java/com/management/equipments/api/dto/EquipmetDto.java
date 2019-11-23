package com.management.equipments.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EquipmetDto {
	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("price")
	@Expose
	private float price;
	@SerializedName("priceSale")
	@Expose
	private float priceSale;
	@SerializedName("note")
	@Expose
	private String note;
	
	public EquipmetDto() {
		this.id = -1L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(float priceSale) {
		this.priceSale = priceSale;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", priceSale=" + priceSale + ", note="
				+ note + "]";
	}
}
