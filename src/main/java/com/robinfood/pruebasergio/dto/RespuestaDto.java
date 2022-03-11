package com.robinfood.pruebasergio.dto;

import com.robinfood.pruebasergio.model.Respuesta;

import lombok.Data;

@Data
public class RespuestaDto {
    
    public RespuestaDto(Respuesta entity){
        setRespuestadId(entity.getId());
        setRespuestaEnunciado(entity.getEnunciado());
        setOpcionRespuestaEnunciado(entity.getOpcionRespuesta() == null ? null : entity.getOpcionRespuesta().getEnunciado());
        setOpcionRespuestaId(entity.getOpcionRespuesta() == null ? null : entity.getOpcionRespuesta().getId());
        setPreguntaId(entity.getEncuestaPregunta() == null ? null : entity.getEncuestaPregunta().getPregunta().getId());
        setPreguntaEnunciado(entity.getEncuestaPregunta() == null ? null : entity.getEncuestaPregunta().getPregunta().getEnunciado());
    }
    
    private Long respuestadId;
    private String respuestaEnunciado;
    private Long opcionRespuestaId;
    private String opcionRespuestaEnunciado;
    private Long preguntaId;
    private String preguntaEnunciado;
}
