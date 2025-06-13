/**
 * 
 */
package com.skb.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.skb.app.exception.UserServiceException;
import com.skb.app.ui.model.UpdateUserDetailsRequestModel;
import com.skb.app.ui.model.User;
import com.skb.app.ui.model.UserDetailsRequestModel;
import com.skb.app.userservice.UserService;

/**
 * @author skbiswas
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	Map<String, User> userMap = null;

	@Autowired
	UserService userService;
	/*
	 * @GetMapping public String getUsers() { return "Get User invoked"; }
	 */

	/**
	 * In order to return custom status code other than the default 200,
	 * ResponseEntity needs to be returned.
	 * 
	 * @param userId
	 * @return
	 */

	/*
	 * @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE }) public User getUserById(@PathVariable
	 * String userId) { User user = new User(); user.setEmail("test@test.com");
	 * user.setFirstName("SK"); user.setLastName("Biswas"); return user; }
	 */
	/*
	 * @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<User>
	 * getUserById(@PathVariable String userId) { User user = new User();
	 * user.setEmail("test@test.com"); user.setFirstName("SK");
	 * user.setLastName("Biswas");
	 * 
	 * return new ResponseEntity<User>(user,HttpStatus.OK); //return new
	 * ResponseEntity<User>(HttpStatus.BAD_REQUEST); }
	 */
	/*
	 * @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<User>
	 * getUserById(@PathVariable String userId) { User user = null;
	 * ResponseEntity<User> responseEntity = new
	 * ResponseEntity<User>(HttpStatus.NOT_FOUND); if(userMap != null) {
	 * responseEntity = userMap.containsKey(userId) ? new
	 * ResponseEntity<User>(userMap.get(userId), HttpStatus.OK) : responseEntity; }
	 * return responseEntity; }
	 */
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		/*
		 * String firstName = null; int nameLength = firstName.length();
		 */
		if (true) {
			throw new UserServiceException("Exception in User Controller");
		}

		User user = null;
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		if (userMap != null) {
			responseEntity = userMap.containsKey(userId) ? new ResponseEntity<User>(userMap.get(userId), HttpStatus.OK)
					: responseEntity;
		}
		return responseEntity;
	}

	@GetMapping
	public String getUserByParam(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "40") Integer limit,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		return "Get User invoked for page: " + page + ", with a limit of " + limit + ", sort:" + sort;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@Validated @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		
		User user = userService.createUser(userDetailsRequestModel);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable String userId,
			@Validated @RequestBody UpdateUserDetailsRequestModel userDetailsRequestModel) {

		ResponseEntity<User> responseEntity = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		if (userMap != null && userMap.containsKey(userId)) {
			User user = userMap.get(userId);
			user.setFirstName(userDetailsRequestModel.getFirstName());
			user.setLastName(userDetailsRequestModel.getLastName());

			/** Though redundant, let us update the User object explicitly */
			userMap.put(userId, user);

			responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);

		}
		return responseEntity;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		if (null != userMap) {
			userMap.remove(userId);
		}
		return ResponseEntity.noContent().build();
	}

}
