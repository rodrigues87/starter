package com.senac.starter.controllers;

import com.senac.starter.models.Postagem;
import com.senac.starter.repositorys.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    PostagemRepository postagemRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("postagem/postagens");
        List<Postagem> postagens =postagemRepository.findAll();
        modelAndView.addObject("postagens", postagens);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharPostagem(@PathVariable Long id){

        Postagem postagem = postagemRepository.findPostagemById(id);
        ModelAndView modelAndView  = new ModelAndView("postagem/postagem-detalhe");
        modelAndView.addObject("postagem",postagem);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("postagem/postagem-detalhe");
        Postagem postagem = new Postagem();
        modelAndView.addObject("postagem", postagem);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarPostagem(Postagem postagem){

        postagemRepository.save(postagem);
        return "redirect:/postagens";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Postagem postagem = postagemRepository.findPostagemById(id);
        postagemRepository.delete(postagem);
        return "redirect:/postagens";
    }
}
