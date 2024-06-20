package com.example.estudo2.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.estudo2.model.entity.Venda;
import com.example.estudo2.model.repository.VendaRepository;

import jakarta.transaction.Transactional;

@Transactional
@RequestMapping("venda")
@Controller
public class VendaController {

    @Autowired
    VendaRepository repository;


    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("venda", repository.vendas());
        return new ModelAndView("/venda/list");
    }
    @GetMapping("/detalhe/{id}")
    public ModelAndView edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("venda", repository.venda(id));
        return new ModelAndView("/venda/detalhe", model);
    }



//    @GetMapping("/form")
//    public String form(Venda venda){
//        return "/produto/form";
//    }
//
//    @PostMapping("/save")
//    public ModelAndView save(Venda venda){
//        repository.save(venda);
//        return new ModelAndView("redirect:/venda/list");
//    }
//
//    @GetMapping("/remove/{id}")
//    public ModelAndView remove(@PathVariable("id") Long id){
//        repository.remove(id);
//        return new ModelAndView("redirect:/venda/list");
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") long id, ModelMap model) {
//        model.addAttribute("venda", repository.venda(id));
//        return new ModelAndView("/venda/form", model);
//    }
//
//    @PostMapping("/update")
//    public ModelAndView update(Venda venda) {
//        repository.update(venda);
//        return new ModelAndView("redirect:/venda/list");
//    }
}
