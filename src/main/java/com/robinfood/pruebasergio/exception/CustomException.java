package com.robinfood.pruebasergio.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/** Clase para representar una exepción personalizada que puede ser lanzada por la aplicación */
@Data
public class CustomException extends RuntimeException{
    
    private HttpStatus status;
    
    CustomException(HttpStatus status, String s){
        super(s);
        this.status = status;
    }
    
    CustomException(HttpStatus status){
        super();
        this.status = status;
    }

        

}

