package com.example.estudo2.model.controller;

import com.example.estudo2.model.entity.Produto;
import com.example.estudo2.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("produto")
@Transactional
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;


    @GetMapping("/detalhe")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produto", repository.produtos());
        return new ModelAndView("/venda/detalhe");
    }

//    @PostMapping("/save")
//    public ModelAndView save(Produto produto){
//        repository.save(produto);
//        return new ModelAndView("redirect:/venda/list");
//    }

//    @GetMapping("/remove/{id}")
//    public ModelAndView remove(@PathVariable("id") Long id){
//        repository.remove(id);
//        return new ModelAndView("redirect:/produto/list");
//    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") long id, ModelMap model) {
//        model.addAttribute("produto", repository.produto(id));
//        return new ModelAndView("/produto/form", model);
//    }

//    @PostMapping("/update")
//    public ModelAndView update(Produto produto) {
//        repository.update(produto);
//        return new ModelAndView("redirect:/produto/list");
//    }

}
