package com.juston.justonprogrammingchallenge.entity;


public class Meta { 

	
	private Integer digits; 
	private String processPattern;
	
	public Meta() {};
		
	public Meta(int digits, String processPattern) {
		this.digits = digits;
		this.processPattern = processPattern;
	}

	public Integer getDigits() {
		return digits;
	}
	public void setDigits(Integer digits) {
		this.digits = digits;
	}
	public String getProcessPattern() {
		return processPattern;
	}
	public void setProcessPattern(String processPattern) {
		this.processPattern = processPattern;
	} 
	
	
}
