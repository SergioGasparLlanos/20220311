package com.robinfood.pruebasergio.controller;

import java.util.List;

import javax.validation.Valid;

import com.robinfood.pruebasergio.model.Respuesta;
import com.robinfood.pruebasergio.service.IRespuestaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {
    
    private final IRespuestaService service;
    
    public RespuestaController(IRespuestaService service){
        this.service = service;
    }


    /** Para guardar la respuesta de un formulario */
    @PostMapping("")
    public ResponseEntity<?> createPost(@Valid @RequestBody List<Respuesta> respuestas){
        return new ResponseEntity<>(service.create(respuestas), HttpStatus.CREATED);
    }


    /** Buscar las respuestas de un formulario por id encuesta */
    @GetMapping("/encuesta/{encuestaId}")
    public ResponseEntity<?> findEncuestaById(@PathVariable("encuestaId") Long encuestaId){
        return ResponseEntity.ok().body(service.findRespuestasByEncuestaId(encuestaId));
    }


}
