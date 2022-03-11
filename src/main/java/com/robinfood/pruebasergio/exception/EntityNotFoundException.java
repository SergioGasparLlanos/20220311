package com.robinfood.pruebasergio.exception;

import org.springframework.http.HttpStatus;

/** Clase para representar una exepción que puede ser lanzada 
 * cuando se busca una entidad en la bd pero no pudo ser encontrada */
public class EntityNotFoundException extends CustomException{

    public EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public EntityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}

