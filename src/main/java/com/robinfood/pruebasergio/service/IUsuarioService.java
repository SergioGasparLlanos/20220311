package com.robinfood.pruebasergio.service;

import com.robinfood.pruebasergio.dto.UsuarioDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {
    
    Page<UsuarioDto> findAll(Pageable pageable);
    
}
