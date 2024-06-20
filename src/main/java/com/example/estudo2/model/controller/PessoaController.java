package com.example.estudo2.model.controller;

import com.example.estudo2.model.entity.ClientePF;
import com.example.estudo2.model.entity.Pessoa;
import com.example.estudo2.model.repository.ClientePfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    ClientePfRepository repository;

    @GetMapping("/form")
    public String form(Pessoa pessoa){
        return "/pessoa/form";
    }

    @PostMapping("/save")
    public ModelAndView save(ClientePF clientePF){
        repository.save(clientePF);
        return new ModelAndView("redirect:/pessoa/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.clientePF(id));
        return new ModelAndView("/pessoa/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("msg","Lista de Clientes");
        model.addAttribute("clientes", repository.clientePFS());
        return new ModelAndView("/pessoa/list"); //caminho para a view
    }

}
