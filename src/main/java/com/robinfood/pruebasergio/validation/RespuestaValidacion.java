package com.robinfood.pruebasergio.validation;

import java.util.List;
import java.util.Optional;

import com.robinfood.pruebasergio.exception.EntityNotFoundException;
import com.robinfood.pruebasergio.exception.PreguntaYaRespondidaException;
import com.robinfood.pruebasergio.exception.RespuestasSizeTooSmallException;
import com.robinfood.pruebasergio.model.EncuestaPregunta;
import com.robinfood.pruebasergio.model.OpcionRespuesta;
import com.robinfood.pruebasergio.model.Respuesta;
import com.robinfood.pruebasergio.repository.EncuestaPreguntaRepo;
import com.robinfood.pruebasergio.repository.OpcionRespuestaRepo;
import com.robinfood.pruebasergio.repository.RespuestaRepo;

import org.springframework.stereotype.Component;

@Component
public class RespuestaValidacion {
    
    private final OpcionRespuestaRepo opcionRespuestaRepo;
    private final EncuestaPreguntaRepo encuestaPreguntaRepo;
    private final RespuestaRepo respuestaRepo;

    public RespuestaValidacion(
        OpcionRespuestaRepo opcionRespuestaRepo, 
        EncuestaPreguntaRepo encuestaPreguntaRepo,
        RespuestaRepo respuestaRepo)
    {
        this.opcionRespuestaRepo = opcionRespuestaRepo;
        this.encuestaPreguntaRepo = encuestaPreguntaRepo;
        this.respuestaRepo = respuestaRepo;
    }


    public void validar(List<Respuesta> listadoRespuestas){

        if(listadoRespuestas == null || listadoRespuestas.size() < 1){
            throw new RespuestasSizeTooSmallException("Debe ingresar las respuestas");
        }

        for(Respuesta rta : listadoRespuestas){//recorre cada respuesta

            if(rta.getEncuestaPregunta() == null ) throw new EntityNotFoundException("Debe ingresar la pregunta");
            Long preguntaId = rta.getEncuestaPregunta().getId();
            Optional<EncuestaPregunta> preg = encuestaPreguntaRepo.findById(preguntaId);
            if(preg.isEmpty()) throw new EntityNotFoundException("No se encontró la pregunta con id "+preguntaId);
            
            //valida que una pregunta no haya sido respondida antes
            if(respuestaRepo.findRespuestasByEncuestaPreguntaId(preguntaId).size() > 0){
                throw new PreguntaYaRespondidaException("La encuesta pregunta con id "+ preguntaId +" ya fue respondida");
            }

            //si se ha llenado con opcion de rta
            if(rta.getOpcionRespuesta() != null && rta.getOpcionRespuesta().getId() != null){
                Long opcionRepuestaId = rta.getOpcionRespuesta().getId();
                Optional<OpcionRespuesta> res = opcionRespuestaRepo.findById(opcionRepuestaId);
                if(res.isEmpty()){//validar que el id de la respuesta exista
                    throw new EntityNotFoundException("No se encontró la respuesta con id "+opcionRepuestaId);
                }
            }
            else{//si se ha llenado con enunciado
                if(rta.getEnunciado() == null || rta.getEnunciado().length() < 2){
                    throw new EntityNotFoundException("Debe ingresar el enunciado de la respuesta");
                }
                
            }
            
        }
    }
}
