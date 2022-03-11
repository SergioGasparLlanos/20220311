package com.robinfood.pruebasergio.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@Table(name = "preguntas")
@SQLDelete(sql = "UPDATE preguntas SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at is null")
@Data
public class Pregunta {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe ingresar el enunciado de la pregunta")
    @NotBlank(message = "Debe ingresar el enunciado de la pregunta")
    @Column(name = "enunciado")
    private String enunciado;

}
