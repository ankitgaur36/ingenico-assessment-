package com.ingenico.nl.dto;

/* @author Ankit
 * This is Message class which will use to send response message
*/
public class MessageDTO {
	private String message;

	public MessageDTO(String message) {
		this.message = message;
	}

	public MessageDTO() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
