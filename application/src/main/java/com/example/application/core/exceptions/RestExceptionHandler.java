package com.example.application.core.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.application.core.model.ResponseError;
import com.example.application.core.model.ResponseError.ObjectError;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	private String getMessage(MessageSourceResolvable messageSourceResolvable) {
    	return messageSource.getMessage(messageSourceResolvable, LocaleContextHolder.getLocale());
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(Exception ex, WebRequest request) {		
		List<ObjectError> errors = ((BindException) ex).getBindingResult().getFieldErrors().stream()
                .map(error -> new ObjectError(error.getField(), getMessage(error)))
                .collect(Collectors.toList());
        ResponseError errorResponse = new ResponseError(HttpStatus.BAD_REQUEST.value(), "Dados obrigatórios não preenchidos.", errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(DataViolationException.class)
    public ResponseEntity<Object> handleDataViolationException(DataViolationException ex, WebRequest request) {
        ResponseError error = new ResponseError(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
	
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundExceptionException(NotFoundException ex, WebRequest request) {
        ResponseError error = new ResponseError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(Exception.class)  
    public final ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {   
    	ResponseError error = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    } 
	
}