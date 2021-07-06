package com.gussoft.Security.utils;

import com.gussoft.Security.models.Usuario;
import com.gussoft.Security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Usuario usuario = repo.findByUsername(user);
        User.UserBuilder builder = null;
        if (usuario != null){
            builder = User.withUsername(user);
            builder.disabled(false);
            builder.password(usuario.getPass());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado!");
        }
        return builder.build();
    }
}
