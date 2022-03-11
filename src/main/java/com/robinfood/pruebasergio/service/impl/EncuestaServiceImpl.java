package com.robinfood.pruebasergio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.robinfood.pruebasergio.dto.EncuestaDto;
import com.robinfood.pruebasergio.dto.EncuestaPreguntaDto;
import com.robinfood.pruebasergio.exception.EntityNotFoundException;
import com.robinfood.pruebasergio.model.Encuesta;
import com.robinfood.pruebasergio.model.EncuestaPregunta;
import com.robinfood.pruebasergio.model.OpcionRespuesta;
import com.robinfood.pruebasergio.repository.EncuestaPreguntaRepo;
import com.robinfood.pruebasergio.repository.EncuestaRepo;
import com.robinfood.pruebasergio.repository.OpcionRespuestaRepo;
import com.robinfood.pruebasergio.service.EncuestaService;

import org.springframework.stereotype.Service;

@Service
public class EncuestaServiceImpl implements EncuestaService {
    
    private final EncuestaPreguntaRepo encuestaPreguntaRepo;
    private final OpcionRespuestaRepo opcionRespuestaRepo;
    private final EncuestaRepo encuestaRepo; 

    
    public EncuestaServiceImpl(
        EncuestaPreguntaRepo encuestaPreguntaRepo, 
        OpcionRespuestaRepo opcionRespuestaRepo,
        EncuestaRepo encuestaRepo)
    {
        this.encuestaPreguntaRepo = encuestaPreguntaRepo;
        this.opcionRespuestaRepo = opcionRespuestaRepo;
        this.encuestaRepo = encuestaRepo;
    }

    
    

    
    /** Encuentra una encuesta dado un id de encuesta */
    @Override
    public EncuestaDto findEncuestaById(Long encuestaId) {

        Optional<Encuesta> encuesta = encuestaRepo.findById(encuestaId);
        if(encuesta.isEmpty()){
            throw new EntityNotFoundException("La encuesta con id " + encuestaId +" no fue encontrada");
        }
        //busca las preguntas de una encuesta
        List<EncuestaPregunta> preguntasList = encuestaPreguntaRepo.findPreguntasByEncuestaId(encuestaId);
        List<EncuestaPreguntaDto> dtoListPreguntas = new ArrayList<EncuestaPreguntaDto>();
        
        for(EncuestaPregunta entity : preguntasList){
            List<OpcionRespuesta> listadoOpcionesRta = opcionRespuestaRepo.findByPreguntaId(entity.getPregunta().getId());
            dtoListPreguntas.add( new EncuestaPreguntaDto(entity, listadoOpcionesRta));
        }

        EncuestaDto encuestaDto = new EncuestaDto(encuesta.get(), dtoListPreguntas);            
        return encuestaDto;
    }


    

}
