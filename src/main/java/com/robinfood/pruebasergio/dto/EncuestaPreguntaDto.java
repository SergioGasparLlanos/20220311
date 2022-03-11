package com.robinfood.pruebasergio.dto;

import java.util.List;

import com.robinfood.pruebasergio.model.EncuestaPregunta;
import com.robinfood.pruebasergio.model.OpcionRespuesta;

import lombok.Data;

@Data
public class EncuestaPreguntaDto {
    
    public EncuestaPreguntaDto(EncuestaPregunta entity, List<OpcionRespuesta> opcionesRespuesta){
        setEncuestaPreguntaId(entity.getId());
        setPreguntaEnunciado(entity.getPregunta().getEnunciado());
        setPreguntaId(entity.getPregunta().getId());
        setEncuestaId(entity.getEncuesta().getId());
        setEncuestaNombre(entity.getEncuesta().getNombre());
        setOpcionesRespuesta(opcionesRespuesta);
    }

    private Long encuestaPreguntaId;
    private String preguntaEnunciado;
    private Long preguntaId;
    private String encuestaNombre;
    private Long encuestaId;
    private List<OpcionRespuesta> opcionesRespuesta;




}
