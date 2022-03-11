package com.robinfood.pruebasergio.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@Table(name = "encuestas_preguntas")
@SQLDelete(sql = "UPDATE encuestas_preguntas SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at is null")
@Data
public class EncuestaPregunta {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotNull(message = "Debe ingresar la encuesta")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "encuesta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Encuesta encuesta;


    @NotNull(message = "Debe ingresar la pregunta")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pregunta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pregunta pregunta;


}
