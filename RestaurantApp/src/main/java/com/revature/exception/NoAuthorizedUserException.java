package com.revature.exception;

public class NoAuthorizedUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029100073065545099L;

	public NoAuthorizedUserException() {
		super();
	}

	public NoAuthorizedUserException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoAuthorizedUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoAuthorizedUserException(String arg0) {
		super(arg0);
	}

	public NoAuthorizedUserException(Throwable arg0) {
		super(arg0);
	}
}
