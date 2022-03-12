package com.senac.starter.controllers;

import com.senac.starter.models.Transacao;
import com.senac.starter.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transacoes")
public class VendaController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("transacao/transacoes");
        List<Transacao> transacoes =vendaRepository.findAll();
        modelAndView.addObject("transacoes", transacoes);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharTransacao(@PathVariable Long id){

        Transacao transacao = vendaRepository.findVendaById(id);
        ModelAndView modelAndView  = new ModelAndView("transacao/transacao-detalhe");
        modelAndView.addObject("transacao",transacao);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("transacao/transacao-detalhe");
        Transacao transacao = new Transacao();
        modelAndView.addObject("transacao", transacao);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarVenda(Transacao transacao){

        vendaRepository.save(transacao);
        return "redirect:/transacoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Transacao transacao = vendaRepository.findVendaById(id);
        vendaRepository.delete(transacao);
        return "redirect:/transacoes";
    }
}
