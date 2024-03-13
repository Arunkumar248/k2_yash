package com.lws.exceptions;



@SuppressWarnings("serial")
public class AutomationException extends Exception {
	/**
	 * User defined exception constructor with message
	 *
	 */
	public AutomationException(String message) {
		super(message);
	}

	/**
	 * User defined exception constructor with message and cause of exception
	 * 
	
	 */
	public AutomationException(String message, Throwable cause) throws AutomationException {
		super(message, cause);
	}

	/**
	 * User defined exception constructor with cause of exception
	 * 
	 */
	public AutomationException(Throwable cause) throws AutomationException {
		super(cause);
	}
}
