package com.senac.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SiteController {

    @GetMapping()
    public ModelAndView dashBoard(){

        return new ModelAndView("dashboard");
    }


    @GetMapping("/filmes")
    public String filmes(){
        System.out.println("entrou no filmes");

        return "filmes";
    }

    @GetMapping("/jogos")
    public String jogos(){
        System.out.println("entrou no jogos");
        return "jogos";
    }
    @GetMapping("/posts")
    public String posts(){
        System.out.println("entrou no posts");

        return "posts";
    }

    @GetMapping("/contato")
    public String contato(){
        System.out.println("entrou no contato");
        return "contato";
    }
}
