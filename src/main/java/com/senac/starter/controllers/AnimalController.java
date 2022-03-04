package com.senac.starter.controllers;

import com.senac.starter.models.Animal;
import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.AnimalRepository;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("animal/animais");
        List<Animal> animais =animalRepository.findAll();
        modelAndView.addObject("animais", animais);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Animal animal = animalRepository.findAnimalById(id);
        ModelAndView modelAndView  = new ModelAndView("animal/animal-detalhe");
        modelAndView.addObject("animal",animal);

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios",usuarios);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("animal/animal-detalhe");
        Animal animal = new Animal();
        modelAndView.addObject("animal", animal);

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios",usuarios);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarUsuario(Animal animal){

        animalRepository.save(animal);
        return "redirect:/animais";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Animal animal = animalRepository.findAnimalById(id);
        animalRepository.delete(animal);
        return "redirect:/animais";
    }
}
