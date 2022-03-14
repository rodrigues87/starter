package com.senac.starter.services;

import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){


        return usuarioRepository.findAll();

    }
}
