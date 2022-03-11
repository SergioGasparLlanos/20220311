package com.robinfood.pruebasergio.repository;

import java.util.List;

import com.robinfood.pruebasergio.model.Respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepo extends JpaRepository<Respuesta, Long> {
    

    @Query(value="select * "
    + " from respuestas res "
    + " inner join encuestas_preguntas epr on epr.id = res.encuesta_pregunta_id "
    + " inner join preguntas pre on pre.id = epr.pregunta_id "
    + " left join opciones_respuestas opr on opr.id = res.opcion_respuesta_id "
    + " where epr.encuesta_id = ?1", nativeQuery=true)
    List<Respuesta> findRespuestasByEncuestaId(Long encuestaId);


    @Query(value="select * from respuestas res "
    + " where res.encuesta_pregunta_id = ?1", nativeQuery=true)
    List<Respuesta> findRespuestasByEncuestaPreguntaId(Long encuestaPreguntaId);

}
