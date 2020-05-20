package com.juston.justonprogrammingchallenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juston.justonprogrammingchallenge.entity.JustOnData;
import com.juston.justonprogrammingchallenge.exception.InvalidDigitException;
import com.juston.justonprogrammingchallenge.exception.NoValueException;

@RestController
public class WebController {
	
	@PostMapping(value = "/api", consumes = "application/json", produces = "application/json")
	public String create(@RequestBody JustOnData input) throws Exception 
	{		
		List<Integer> tempValues = input.getAddress().getValues();
		List<String> tempColorKeys= input.getAddress().getColorKeys();
		int tempDigits =input.getMeta().getDigits(); 
		
		if(tempColorKeys.isEmpty() || tempColorKeys.size() <= 0 )
			throw new NoValueException("ColorKeys' value must be added"); 
		
		if(tempValues.isEmpty() || tempValues.size() <= 0)
			throw new NoValueException("Values' value must be added"); 
		
		if(tempDigits < 0 )
			throw new InvalidDigitException("digits' value must be greater than or equal to 0"); 
	
		Integer sum = 0;  
		for(Integer i : tempValues) {
			sum += i; 
		}
		
		int result =0;
		while(sum > 0)
		{
			result += sum%10; 
			sum /=10; 
			
		}
	
		return String.valueOf(result); 
	}
		
}
