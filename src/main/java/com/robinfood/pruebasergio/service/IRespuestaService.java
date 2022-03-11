package com.robinfood.pruebasergio.service;

import java.util.List;
import java.util.Optional;

import com.robinfood.pruebasergio.dto.RespuestaDto;
import com.robinfood.pruebasergio.model.Respuesta;

public interface IRespuestaService {
    
    List<Respuesta> create(List<Respuesta> respuestas);

    List<RespuestaDto> findRespuestasByEncuestaId(Long encuestaId);

    Optional<RespuestaDto> findRespuestaById(Long respuestaId);
    
}
