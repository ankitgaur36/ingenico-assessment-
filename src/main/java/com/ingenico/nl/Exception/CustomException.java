package com.ingenico.nl.Exception;

public class CustomException  extends Exception {
	/**
	 * the serialVersionUID field
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 */
	public CustomException(String msg) {
		super(msg);
	}

	/**
	 * @param msg
	 * @param cause
	 */
	public CustomException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
