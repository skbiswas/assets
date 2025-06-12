/**
 * 
 */
package com.skb.app.ui.model;

import jakarta.validation.constraints.NotNull;

/**
 * @author skbiswas
 *
 */
public class UpdateUserDetailsRequestModel {
	
	@NotNull (message = "First Name can not be empty")
	private String firstName;
	
	@NotNull (message = "Last Name can not be empty")
	private String lastName;

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
