package com.skb.app.exception;

import java.util.Date;

public class ErrorMessage {

	private Date timeStamp;
	private String message;
	
	public ErrorMessage() {}
	
	public ErrorMessage(Date timeStampParam, String msg) {
		this.timeStamp = timeStampParam;
		this.message = msg;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
