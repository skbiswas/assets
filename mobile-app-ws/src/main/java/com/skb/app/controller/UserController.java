/**
 * 
 */
package com.skb.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skb.app.ui.model.UserRest;

/**
 * @author skbiswas
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	/*
	 * @GetMapping public String getUsers() { return "Get User invoked"; }
	 */
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUserById(@PathVariable String userId) {
		UserRest user = new UserRest();
		user.setEmail("test@test.com");
		user.setFirstName("SK");
		user.setLastName("Biswas");
		return user;
	}
	
	@GetMapping 
	public String getUserByParam(@RequestParam (value = "page") int page, @RequestParam(value="limit", required = false, defaultValue="40" ) Integer limit,
			@RequestParam(value="sort", required=false, defaultValue = "desc") String sort) {
		return "Get User invoked for page: "+page+", with a limit of "+limit+", sort:"+sort;
	}
	
	@PostMapping
	public String createUser() {
		return "Create user invoked";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update user invoked";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user invoked";
	}
	
}
