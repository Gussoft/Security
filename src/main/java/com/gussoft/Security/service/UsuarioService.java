package com.gussoft.Security.service;

import com.gussoft.Security.models.Usuario;

public interface UsuarioService {

    public Usuario findByUsername(String username);

    public Usuario registrar(Usuario u);
}
