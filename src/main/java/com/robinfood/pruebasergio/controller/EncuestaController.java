package com.robinfood.pruebasergio.controller;

import com.robinfood.pruebasergio.service.EncuestaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {
    
    private final EncuestaService service;
    
    public EncuestaController(EncuestaService service){
        this.service = service;
    }

    
    /** Buscar una encuesta por id */
    @GetMapping("/{encuestaId}")
    public ResponseEntity<?> findEncuestaById(@PathVariable("encuestaId") Long encuestaId){
        return ResponseEntity.ok().body(service.findEncuestaById(encuestaId));
    }

    
}
