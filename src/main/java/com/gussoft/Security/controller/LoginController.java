package com.gussoft.Security.controller;

import com.gussoft.Security.models.Usuario;
import com.gussoft.Security.repository.UsuarioRepository;
import com.gussoft.Security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/auth/register")
    public String registerForm(Model model){
        model.addAttribute("usuario",new Usuario());
        return "register";
    }

    @PostMapping("/auth/register")
    public String registro(@Validated @ModelAttribute Usuario usuario, BindingResult result, Model model){
        if (result.hasErrors()){
            return "redirect:/auth/register";
        }else{
            model.addAttribute("usuario", service.registrar(usuario));
        }
        return "redirect:/auth/dologin";
    }

    @GetMapping("/auth/dologin")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
}
