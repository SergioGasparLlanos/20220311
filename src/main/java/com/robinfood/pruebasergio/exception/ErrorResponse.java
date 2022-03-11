package com.robinfood.pruebasergio.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/** Clase para representar la respuesta del error que se 
 * enviará al cliente cuando se lance una exepción */
@Data
public class ErrorResponse {
    
    private int status;//codigo estado http de la respuesta 
    private String error;//nombre del codigo del estado http
    private String message;//mensaje asociado al error

    public ErrorResponse(HttpStatus status) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
    }

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }
        
        
}
