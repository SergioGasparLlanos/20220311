package com.robinfood.pruebasergio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@Table(name = "encuestas")
@SQLDelete(sql = "UPDATE encuestas SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at is null")
@Data
public class Encuesta {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Debe ingresar el nombre")
    @NotBlank(message = "Debe ingresar el nombre")
    @Column(name = "nombre")
    private String nombre;


    @NotNull(message = "Debe ingresar la descripción")
    @NotBlank(message = "Debe ingresar la descripción")
    @Column(name = "descripcion")
    private String descripcion;


    @NotNull(message = "Debe ingresar el usuario")
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;




}
