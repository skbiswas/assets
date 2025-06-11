/**
 * 
 */
package com.skb.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skb.app.ui.model.User;
import com.skb.app.ui.model.UserDetailsRequestModel;

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

	/*
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public User getUserById(@PathVariable String userId) {
		User user = new User();
		user.setEmail("test@test.com");
		user.setFirstName("SK");
		user.setLastName("Biswas");
		return user;
	}
	*/
	
	/**
	 * In order to return custom status code other than the default 200, ResponseEntity needs to be returned.
	 * @param userId
	 * @return
	 */
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		User user = new User();
		user.setEmail("test@test.com");
		user.setFirstName("SK");
		user.setLastName("Biswas");
				
		return new ResponseEntity<User>(user,HttpStatus.OK);
		//return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	public String getUserByParam(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "40") Integer limit,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		return "Get User invoked for page: " + page + ", with a limit of " + limit + ", sort:" + sort;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
				produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@Validated @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		User user = new User();
		user.setEmail(userDetailsRequestModel.getEmail());
		user.setFirstName(userDetailsRequestModel.getFirstName());
		user.setLastName(userDetailsRequestModel.getLastName());
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
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
