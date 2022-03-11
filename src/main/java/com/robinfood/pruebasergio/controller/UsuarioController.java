package com.robinfood.pruebasergio.controller;

import com.robinfood.pruebasergio.service.IUsuarioService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    

    private final IUsuarioService service;

    public UsuarioController(IUsuarioService service){
        this.service = service;
    }
    

    /** Buscar todos los registros */
    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    
    
}
