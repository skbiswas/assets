/**
 * 
 */
package com.sk.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author skbiswas
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/status/check")
	public String status() {
		return "Working";
	}

}
