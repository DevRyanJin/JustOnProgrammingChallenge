package com.juston.justonprogrammingchallenge.exception;

public class InvalidDigitException extends Exception {

	public InvalidDigitException() {
	}

	public InvalidDigitException(String message) {
		super(message);
	}

	public InvalidDigitException(Throwable cause) {
		super(cause);
	}

	public InvalidDigitException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDigitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
