package com.example.estudo2.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.estudo2.model.entity.ItemVenda;
import com.example.estudo2.model.repository.ItemVendaRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("itemVenda")
@Transactional
public class ItemVendaController {

    @Autowired
    ItemVendaRepository repository;


    @GetMapping("/detalhe")
    public ModelAndView listar(@PathVariable("id") ModelMap model) {
        model.addAttribute("itemVenda", repository.ivendas());
        return new ModelAndView("/venda/detalhe");
    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView edit(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("itemVenda", repository.itemVenda(id));
        return new ModelAndView("/venda/detalhe", model);
    }

//    @GetMapping("/form")
//    public String form(ItemVenda itemVenda){
//        return "/produto/form";
//    }
//
//    @PostMapping("/save")
//    public ModelAndView save(ItemVenda itemVenda){
//        repository.save(itemVenda);
//        return new ModelAndView("redirect:/produto/list");
//    }
//
//    @GetMapping("/remove/{id}")
//    public ModelAndView remove(@PathVariable("id") Long id){
//        repository.remove(id);
//        return new ModelAndView("redirect:/produto/list");
//    }
//

//
//    @PostMapping("/update")
//    public ModelAndView update(ItemVenda itemVenda) {
//        repository.update(itemVenda);
//        return new ModelAndView("redirect:/produto/list");
//    }
}
