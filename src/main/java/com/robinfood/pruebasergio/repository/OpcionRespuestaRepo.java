package com.robinfood.pruebasergio.repository;

import java.util.List;

import com.robinfood.pruebasergio.model.OpcionRespuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRespuestaRepo extends JpaRepository<OpcionRespuesta, Long> {

    
    @Query(value = "select * from opciones_respuestas where pregunta_id = :preguntaId", nativeQuery = true)
    List<OpcionRespuesta> findByPreguntaId(@Param("preguntaId") Long preguntaId);


}
