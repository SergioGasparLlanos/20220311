package com.robinfood.pruebasergio.exception;

import org.springframework.http.HttpStatus;

/** Clase para representar una exepción que puede ser lanzada 
 * cuando se busca no se envian respuestas para guardar  */
public class RespuestasSizeTooSmallException extends CustomException{



    public RespuestasSizeTooSmallException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public RespuestasSizeTooSmallException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
