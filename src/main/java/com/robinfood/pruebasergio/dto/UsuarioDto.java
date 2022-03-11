package com.robinfood.pruebasergio.dto;

import com.robinfood.pruebasergio.model.Usuario;

import lombok.Data;

@Data
public class UsuarioDto {
    
    public UsuarioDto(Usuario entity){
        setId(entity.getId());
        setNombre(entity.getNombre());
        setApellido(entity.getApellido());
        setCorreo(entity.getCorreo());
    }

    private Long id;
    private String nombre;
    private String apellido;
    private String correo;

}
