package com.skb.app.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotNull (message = "First Name can not be empty")
	private String firstName;
	
	@NotNull (message = "Last Name can not be empty")
	private String lastName;

	@Email (message = "Email has to be of valid format")
	private String email;
	
	@NotNull(message = "Password can not be empty")
	@Size(min = 8, max= 16, message = "Password has to be at least 8 and less than 16 characters")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
