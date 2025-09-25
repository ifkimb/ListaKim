package com.listakim.listakim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.listakim.listakim.model.Item;
import com.listakim.listakim.repository.ItemRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/itens")
public class ItensController{
     
    @Autowired
    private ItemRepository repository;

    @GetMapping
    public String listItens(Model model) {
        model.addAttribute("itens", repository.findAll());
        return "itens";
    }

@GetMapping("/form")
    public String showForm(Item item){
        return "form";
    }

@PostMapping
public String create(@Valid Item item, BindingResult result, RedirectAttributes redirect){
    if(result.hasErrors()) return "form";

    System.out.println("Adicionando Item..." + item);
        repository.save(item);
        redirect.addFlashAttribute("message", "Item adicionado com sucesso");
        return "redirect:/itens";
    }

}

