/**
 * 
 */
package com.skb.app.userservice;

import com.skb.app.ui.model.User;
import com.skb.app.ui.model.UserDetailsRequestModel;

/**
 * @author skbiswas
 *
 */
public interface UserService {
	
	User createUser(UserDetailsRequestModel userDetails);

}
