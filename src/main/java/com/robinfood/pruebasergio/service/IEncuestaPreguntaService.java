package com.robinfood.pruebasergio.service;

import com.robinfood.pruebasergio.dto.EncuestaPreguntaDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEncuestaPreguntaService {
    
    Page<EncuestaPreguntaDto> findPreguntasByEncuestaId(Long encuestaId, Pageable pageable);

}
