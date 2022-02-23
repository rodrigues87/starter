package com.senac.starter.controllers;

import com.senac.starter.models.Produto;
import com.senac.starter.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("produto/produtos");
        List<Produto> produtos =produtoRepository.findAll();
        modelAndView.addObject("produtos", produtos);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharProduto(@PathVariable Long id){

        Produto produto = produtoRepository.findProdutoById(id);
        ModelAndView modelAndView  = new ModelAndView("produto/produto-detalhe");
        modelAndView.addObject("produto",produto);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("produto/produto-detalhe");
        Produto produto = new Produto();
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarProduto(Produto produto){

        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Produto produto = produtoRepository.findProdutoById(id);
        produtoRepository.delete(produto);
        return "redirect:/produtos";
    }
}
