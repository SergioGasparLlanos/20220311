package com.robinfood.pruebasergio.service.impl;

import java.util.function.Function;

import com.robinfood.pruebasergio.dto.UsuarioDto;
import com.robinfood.pruebasergio.model.Usuario;
import com.robinfood.pruebasergio.repository.UsuarioRepo;
import com.robinfood.pruebasergio.service.IUsuarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepo usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        Page<Usuario> entityPage =  usuarioRepo.findAll(pageable);
        Page<UsuarioDto> dtoPage = entityPage.map(new Function<Usuario, UsuarioDto>() {
            @Override public UsuarioDto apply(Usuario source) {
                return new UsuarioDto(source);
            }
        });
        return dtoPage;
    }
    


    
}
