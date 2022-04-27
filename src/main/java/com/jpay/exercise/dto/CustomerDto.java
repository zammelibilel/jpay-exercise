package com.jpay.exercise.dto;

/**
 * 
 * @author zammelib
 *
 */
public class CustomerDto {

	private Long id;
	private String name;
	private String phone;
	private boolean isValid = false;
	private String country;

	public CustomerDto(Long id, String name, String phone, boolean isValid, String country) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.isValid = isValid;
		this.country = country;
	}

	public CustomerDto() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
