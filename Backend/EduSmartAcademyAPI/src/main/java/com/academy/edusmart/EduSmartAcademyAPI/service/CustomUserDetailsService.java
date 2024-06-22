package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import com.academy.edusmart.EduSmartAcademyAPI.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsername(username);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            return org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles(usuario.getRol().getNombre().toUpperCase())
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }
}
