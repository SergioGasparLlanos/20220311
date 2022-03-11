package com.robinfood.pruebasergio.repository;

import java.util.List;

import com.robinfood.pruebasergio.model.EncuestaPregunta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaPreguntaRepo extends JpaRepository<EncuestaPregunta, Long>{
    

    @Query(value = "select * "
    + " from encuestas_preguntas epr "
    + " inner join encuestas enc on enc.id = epr.encuesta_id "
    + " inner join preguntas pre on pre.id = epr.pregunta_id "
    + " where enc.id = :encuestaId", nativeQuery = true)
    Page<EncuestaPregunta> findPreguntasByEncuestaId(
        @Param("encuestaId") Long encuestaId, Pageable pageable);


    @Query(value = "select * "
    + " from encuestas_preguntas epr "
    + " inner join encuestas enc on enc.id = epr.encuesta_id "
    + " inner join preguntas pre on pre.id = epr.pregunta_id "
    + " where enc.id = :encuestaId", nativeQuery = true)
    List<EncuestaPregunta> findPreguntasByEncuestaId(
        @Param("encuestaId") Long encuestaId);
        

}
