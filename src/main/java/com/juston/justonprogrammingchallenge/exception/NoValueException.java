package com.juston.justonprogrammingchallenge.exception;

public class NoValueException extends Exception {

	public NoValueException() {
	}

	public NoValueException(String message) {
		super(message);
	}

	public NoValueException(Throwable cause) {
		super(cause);
	}

	public NoValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
