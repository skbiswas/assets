/**
 * 
 */
package com.skb.app.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skb.app.ui.model.User;
import com.skb.app.ui.model.UserDetailsRequestModel;
import com.skb.app.util.Utils;

/**
 * @author skbiswas
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	Map<String, User> userMap = null;
	Utils utils = null;
	public UserServiceImpl() {		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public User createUser(UserDetailsRequestModel userDetailsRequestModel) {
		User user = new User();
		//String userId = UUID.randomUUID().toString();
		String userId = utils.generateUserId();
		user.setEmail(userDetailsRequestModel.getEmail());
		user.setFirstName(userDetailsRequestModel.getFirstName());
		user.setLastName(userDetailsRequestModel.getLastName());
		user.setUserId(userId);
		
		
		if(null == userMap) {
			userMap = new HashMap<>();
		}
		userMap.put(userId, user);
		
		return user;
	}

}
