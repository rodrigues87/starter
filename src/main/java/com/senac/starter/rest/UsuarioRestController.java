package com.senac.starter.rest;

import com.senac.starter.models.Animal;
import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping()
    public Usuario find(){

        Usuario usuario = usuarioRepository.findUsuarioById(1L);
        return usuario;

    }

    @GetMapping("{id}")
    public List<Animal> animaisDoDono(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        return usuario.getAnimais();

    }
}
