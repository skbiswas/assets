/**
 * 
 */
package com.skb.app.util;

import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * @author skbiswas
 *
 */
@Service
public class Utils {
	
	public String generateUserId() {
		return UUID.randomUUID().toString();
	}

}
