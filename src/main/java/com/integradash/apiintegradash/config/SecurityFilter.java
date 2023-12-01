package com.integradash.apiintegradash.config;

import com.integradash.apiintegradash.repositories.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletRequest response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals("/usuarios") && request.getMethod().equals("GET")) {
            filterChain.doFilter(request, response);
            return;
        }

        var token = receberToken(request);

        if (token != null)
    }
}
