package com.robinfood.pruebasergio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.robinfood.pruebasergio.dto.RespuestaDto;
import com.robinfood.pruebasergio.exception.EntityNotFoundException;
import com.robinfood.pruebasergio.model.Respuesta;
import com.robinfood.pruebasergio.repository.EncuestaRepo;
import com.robinfood.pruebasergio.repository.RespuestaRepo;
import com.robinfood.pruebasergio.service.IRespuestaService;
import com.robinfood.pruebasergio.validation.RespuestaValidacion;

import org.springframework.stereotype.Service;

@Service
public class RespuestaServiceImpl implements IRespuestaService{

    private final RespuestaRepo respuestaRepo;
    private final RespuestaValidacion respuestaValidacion;
    private final EncuestaRepo encuestaRepo;
    
    public RespuestaServiceImpl(
        RespuestaRepo respuestaRepo, 
        RespuestaValidacion respuestaValidacion,
        EncuestaRepo encuestaRepo){
        this.respuestaRepo = respuestaRepo;
        this.respuestaValidacion = respuestaValidacion;
        this.encuestaRepo = encuestaRepo;
    }


    @Override
    public List<Respuesta> create(List<Respuesta> respuestas) {
        respuestaValidacion.validar(respuestas);
        return respuestaRepo.saveAll(respuestas);
    }


    @Override
    public List<RespuestaDto> findRespuestasByEncuestaId(Long encuestaId) {

        if(encuestaRepo.findById(encuestaId).isEmpty()){
            throw new EntityNotFoundException("La encuesta con id " + encuestaId +" no fue encontrada");
        }

        List<Respuesta> respuestasEntity = respuestaRepo.findRespuestasByEncuestaId(encuestaId);
        List<RespuestaDto> respuestasDto = new ArrayList<RespuestaDto>();
        for(Respuesta res: respuestasEntity){
            respuestasDto.add(new RespuestaDto(res));
        }
        return respuestasDto;
    }

    @Override
    public Optional<RespuestaDto> findRespuestaById(Long respuestaId){
        Optional<Respuesta> respuesta = respuestaRepo.findById(respuestaId);
        if(respuesta.isEmpty()){
            throw new EntityNotFoundException("La respuesta con id "+respuestaId+ " no fue encontrada");
        }
        return Optional.of(new RespuestaDto( respuesta.get() ));
    }
    
    
}
