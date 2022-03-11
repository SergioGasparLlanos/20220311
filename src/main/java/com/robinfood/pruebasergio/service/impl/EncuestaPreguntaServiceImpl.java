package com.robinfood.pruebasergio.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.robinfood.pruebasergio.dto.EncuestaPreguntaDto;
import com.robinfood.pruebasergio.exception.EntityNotFoundException;
import com.robinfood.pruebasergio.model.EncuestaPregunta;
import com.robinfood.pruebasergio.model.OpcionRespuesta;
import com.robinfood.pruebasergio.repository.EncuestaPreguntaRepo;
import com.robinfood.pruebasergio.repository.EncuestaRepo;
import com.robinfood.pruebasergio.repository.OpcionRespuestaRepo;
import com.robinfood.pruebasergio.service.IEncuestaPreguntaService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EncuestaPreguntaServiceImpl implements IEncuestaPreguntaService{

    private final EncuestaPreguntaRepo encuestaPreguntaRepo;
    private final OpcionRespuestaRepo opcionRespuestaRepo;
    private final EncuestaRepo encuestaRepo;

    
    public EncuestaPreguntaServiceImpl(
        EncuestaPreguntaRepo encuestaPreguntaRepo, 
        OpcionRespuestaRepo opcionRespuestaRepo,
        EncuestaRepo encuestaRepo)
    {
        this.encuestaPreguntaRepo = encuestaPreguntaRepo;
        this.opcionRespuestaRepo = opcionRespuestaRepo;
        this.encuestaRepo = encuestaRepo;
    }


    /** Encuentra una pagina de preguntas dado un id de encuesta */
    @Override
    public Page<EncuestaPreguntaDto> findPreguntasByEncuestaId(Long encuestaId, Pageable pageable) {

        if(encuestaRepo.findById(encuestaId).isEmpty()){
            throw new EntityNotFoundException("La encuesta con id " + encuestaId +" no fue encontrada");
        }

        Page<EncuestaPregunta> entityPage = encuestaPreguntaRepo.findPreguntasByEncuestaId(encuestaId, pageable);
        List<EncuestaPreguntaDto> dtoList = new ArrayList<EncuestaPreguntaDto>();

        for(EncuestaPregunta entity : entityPage.getContent()){
            List<OpcionRespuesta> listadoOpcionesRta = opcionRespuestaRepo.findByPreguntaId(entity.getPregunta().getId());
            dtoList.add( new EncuestaPreguntaDto(entity, listadoOpcionesRta));
        }
        Page<EncuestaPreguntaDto> dtoPage = 
            new PageImpl<EncuestaPreguntaDto>(dtoList, pageable, entityPage.getTotalElements());
            
        return dtoPage;
    }
    

}
