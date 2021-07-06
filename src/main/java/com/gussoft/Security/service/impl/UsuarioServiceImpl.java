package com.gussoft.Security.service.impl;

import com.gussoft.Security.models.Usuario;
import com.gussoft.Security.repository.UsuarioRepository;
import com.gussoft.Security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Usuario findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Usuario registrar(Usuario u) {
        u.setPass(encoder.encode(u.getPass()));
        return repo.save(u);
    }
}
