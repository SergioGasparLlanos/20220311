package com.robinfood.pruebasergio.dto;

import java.util.List;

import com.robinfood.pruebasergio.model.Encuesta;

import lombok.Data;

@Data
public class EncuestaDto{

    public EncuestaDto(Encuesta encuesta, List<EncuestaPreguntaDto> preguntas){
        setEncuestaId(encuesta.getId());
        setEncuestaNombre(encuesta.getNombre());
        setEncuestaDescripcion(encuesta.getDescripcion());
        setPreguntas(preguntas);
    }

    private Long encuestaId;
    private String encuestaNombre;
    private String encuestaDescripcion;
    private List<EncuestaPreguntaDto> preguntas;

}