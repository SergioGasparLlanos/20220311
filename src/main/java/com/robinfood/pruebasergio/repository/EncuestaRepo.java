package com.robinfood.pruebasergio.repository;

import java.util.Optional;

import com.robinfood.pruebasergio.model.Encuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepo extends JpaRepository<Encuesta, Long> {
    
    @Query(value = "select * from encuestas where id = ?1", nativeQuery = true)
    Optional<Encuesta> findEncuestaById(Long id);

}
