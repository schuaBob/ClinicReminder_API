package com.huaclinic.restfulapi.payload.response;

public class MessageRes {
    private String message;

	public MessageRes(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
