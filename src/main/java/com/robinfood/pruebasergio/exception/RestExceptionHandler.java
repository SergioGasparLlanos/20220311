package com.robinfood.pruebasergio.exception;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** Clase para declarar métodos relacionados con el manejo de excepciones 
 * que serán compartidos entre múltiples controladores */
@ControllerAdvice
public class RestExceptionHandler{
	
	
	/**
	 * Se encarga de manejar las excepciones que se lancen a través de CustomException
	 */
	@ExceptionHandler(value = {CustomException.class})
	protected ResponseEntity<Object> handleMyCustomException(CustomException ex) {
        HashMap<String, Object> error = new HashMap<String, Object>();
        error.put("status", ex.getStatus());
        error.put("message", ex.getMessage());
	    return new ResponseEntity<>(error, ex.getStatus());
	}


}
