package com.gussoft.Security.controller;

import com.gussoft.Security.models.Usuario;
import com.gussoft.Security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){
        String username = auth.getName();
        if (session.getAttribute("usuario") == null){
            Usuario usuario = service.findByUsername(username);
            usuario.setPass(null);
            session.setAttribute("usuario", usuario);
        }
        return "index";
    }
}
