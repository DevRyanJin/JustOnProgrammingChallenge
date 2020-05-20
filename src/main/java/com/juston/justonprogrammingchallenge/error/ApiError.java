package com.juston.justonprogrammingchallenge.error;

import java.time.Instant;

public class ApiError {

	    private int code;
	    private String message;
	    private Instant timestamp;
	    private String error; 

	    public ApiError(int code, String message) {
	        this.code = code;
	        this.message = message;
	        this.timestamp = Instant.now();
	    }

	    public ApiError(int code, String message, String err) {
	        this.code = code;
	        this.message = message;
	        this.timestamp = Instant.now();
	        this.error = err; 
	    }

	 
	    public ApiError(int code, String message, Instant timestamp) {
	        this.code = code;
	        this.message = message;
	        this.timestamp = timestamp;
	    }


		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Instant getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Instant timestamp) {
			this.timestamp = timestamp;
		}

	    	
}
