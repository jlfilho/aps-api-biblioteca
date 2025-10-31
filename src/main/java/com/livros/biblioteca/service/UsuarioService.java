package com.livros.biblioteca.service;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livros.biblioteca.model.Usuario;
import com.livros.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
        return new User(usuario.getUsername(), usuario.getPassword(), Collections.singleton(authority));
    }

    public Usuario registrarUsuario(String username, String rawPassword, String role) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Usuário já existe");
        }
        String encoded = passwordEncoder.encode(rawPassword);
        Usuario usuario = Usuario.builder()
                .username(username)
                .password(encoded)
                .role(role == null ? "ROLE_USER" : role)
                .build();
        return usuarioRepository.save(usuario);
    }
}



