package com.example.application.core.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@AllArgsConstructor
public class ResponseError {
	private Integer status_code;
	private String message;
    private final List<ObjectError> errors;

	@Getter
	@AllArgsConstructor
	public static class ObjectError {	
		private final String field;	
	    private final String message;
	    	
    }
    
}
