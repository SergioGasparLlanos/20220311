package com.robinfood.pruebasergio.exception;

import org.springframework.http.HttpStatus;

/** Clase para representar una exepción que puede ser lanzada 
 * cuando se intenta guardar una respuesta que ya ha sido contestada antes  */
public class PreguntaYaRespondidaException extends CustomException {
    
    
    public PreguntaYaRespondidaException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public PreguntaYaRespondidaException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
