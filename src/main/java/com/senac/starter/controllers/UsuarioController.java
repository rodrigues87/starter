package com.senac.starter.controllers;

import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public ModelAndView listar(){
        ModelAndView modelAndView = new ModelAndView("usuario");

        List<Usuario> usuarios =usuarioRepository.findAll();

        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);

        ModelAndView modelAndView  = new ModelAndView("usuario-detalhe");

        modelAndView.addObject("usuario",usuario);

        return modelAndView;
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findUsuarioById(id);
        usuarioRepository.delete(usuario);

        return "redirect:/usuarios";
    }
}
