/**
 * 
 */
package com.skb.app.util;

import java.util.UUID;

/**
 * @author skbiswas
 *
 */
public class Utils {
	
	public String generateUserId() {
		return UUID.randomUUID().toString();
	}

}
