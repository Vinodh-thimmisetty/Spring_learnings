package com.pluralsight.mvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.pluralsight.mvc.view.Phone;

public class Attende {

	@Size(min = 2, max = 30)
	private String name;

	@NotEmpty
	@Email
	private String email;

	@Phone
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Attende [name=" + name + ", email=" + email + "]";
	}

}
