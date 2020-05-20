package com.juston.justonprogrammingchallenge.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Address {

	private List<String> colorKeys; 
	
	private List<Integer> values;
		
	public Address() {}

	public List<String> getColorKeys() {
		return colorKeys;
	}

	public void setColorKeys(List<String> colorKeys) {
		this.colorKeys = colorKeys;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
	
	

	
	
	
}
