package com.robinfood.pruebasergio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "respuestas")
@SQLDelete(sql = "UPDATE preguntas SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at is null")
@Data
public class Respuesta extends EntidadBase{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe ingresar la pregunta")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "encuesta_pregunta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EncuestaPregunta encuestaPregunta;

    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opcion_respuesta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OpcionRespuesta opcionRespuesta;

    @NotBlank(message = "Debe ingresar la respuesta de la pregunta")
    @Column(name = "enunciado", nullable = true)
    private String enunciado;


    @PrePersist
    public void prePersist() {
        setCreatedAt(new Date());
    }

    

}
