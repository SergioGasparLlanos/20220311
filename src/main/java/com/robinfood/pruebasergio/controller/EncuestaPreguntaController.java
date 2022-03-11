package com.robinfood.pruebasergio.controller;

import com.robinfood.pruebasergio.service.IEncuestaPreguntaService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/encuestas-preguntas")
public class EncuestaPreguntaController {
    

    
    private final IEncuestaPreguntaService service;
    public EncuestaPreguntaController(IEncuestaPreguntaService service){
        this.service = service;
    }
    

    /** Buscar todos las preguntas por encuesta */
    @GetMapping("/encuesta/{encuestaId}")
    public ResponseEntity<?> findAllPreguntasByEncuestaId(
            @PathVariable("encuestaId") Long encuestaId,
            @RequestParam(name = "page", defaultValue = "0") int page, 
            @RequestParam(name = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(service.findPreguntasByEncuestaId(encuestaId, pageable));
    }



}
