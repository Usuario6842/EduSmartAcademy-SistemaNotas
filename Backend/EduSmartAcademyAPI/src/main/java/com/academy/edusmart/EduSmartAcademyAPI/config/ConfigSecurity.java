package com.academy.edusmart.EduSmartAcademyAPI.config;

import com.academy.edusmart.EduSmartAcademyAPI.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    private final CustomUserDetailsService customUserDetailsService;

    public ConfigSecurity(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasAnyRole("ADMIN", "ADMINISTRATIVO", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.POST, "/api/usuarios").hasAnyRole("ADMIN", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/usuarios/**").hasAnyRole("ADMIN", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasAnyRole("ADMIN", "SECRETARIO");

                    auth.requestMatchers(HttpMethod.GET, "/api/roles/**").hasAnyRole("ADMIN");

                    auth.requestMatchers(HttpMethod.GET,"/api/personal/**").hasAnyRole("ADMIN", "SECRETARIO", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.POST, "/api/personal").hasAnyRole("ADMIN", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/personal/**").hasAnyRole("ADMIN", "SECRETARIO", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/personal/**").hasAnyRole("ADMIN", "ADMINISTRATIVO");

                    auth.requestMatchers(HttpMethod.POST, "/api/materias").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.PUT,"/api/materias/**").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/materias/**").hasAnyRole("ADMIN");

                    auth.requestMatchers(HttpMethod.GET, "/api/inscripcion/**").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.POST, "/api/inscripcion/**").hasAnyRole("ADMIN", "COORDINADOR","SECRETARIO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/inscripcion/**").hasAnyRole("ADMIN", "COORDINADOR","SECRETARIO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/inscripcion/**").hasAnyRole("ADMIN","SECRETARIO");

                    auth.requestMatchers(HttpMethod.POST, "/api/horario/**").hasAnyRole("ADMIN", "COORDINADOR");
                    auth.requestMatchers(HttpMethod.PUT, "/api/horario/**").hasAnyRole("ADMIN", "COORDINADOR");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/horario/**").hasAnyRole("ADMIN", "COORDINADOR");

                    auth.requestMatchers(HttpMethod.GET, "/api/docente/**").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.POST, "/api/docente").hasAnyRole("ADMIN", "SECRETARIO", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/docente/**").hasAnyRole("ADMIN", "SECRETARIO", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/docente/**").hasAnyRole("ADMIN", "SECRETARIO", "ADMINISTRATIVO");

                    auth.requestMatchers(HttpMethod.GET, "/api/estudiante/**").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO", "ESTUDIANTE");
                    auth.requestMatchers(HttpMethod.POST, "/api/estudiante").hasAnyRole("ADMIN", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/estudiante/**").hasAnyRole("ADMIN", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.DELETE,"/api/estudiante/**").hasAnyRole("ADMIN", "SECRETARIO");

                    auth.requestMatchers(HttpMethod.GET, "/api/cargos/**").hasAnyRole("ADMIN" , "ADMINISTRATIVO", "SECRETARIO", "DOCENTE");
                    auth.requestMatchers(HttpMethod.POST, "/api/cargos").hasAnyRole("ADMIN", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/cargos/**").hasAnyRole("ADMIN", "ADMINISTRATIVO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/cargos/**").hasAnyRole("ADMIN", "ADMINISTRATIVO");

                    auth.requestMatchers(HttpMethod.GET, "/api/notas/**").hasAnyRole("ADMIN", "ADMINISTRATIVO", "SECRETARIO", "DOCENTE", "ESTUDIANTE");
                    auth.requestMatchers(HttpMethod.POST, "/api/notas/**").hasAnyRole("ADMIN", "DOCENTE");
                    auth.requestMatchers(HttpMethod.PUT, "/api/notas/**").hasAnyRole("ADMIN", "DOCENTE");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/notas/**").hasAnyRole("ADMIN");

                    auth.requestMatchers(HttpMethod.GET, "/api/aulas/**").hasAnyRole("ADMIN", "COORDINADOR", "SECRETARIO", "DOCENTE", "ESTUDIANTE");
                    auth.requestMatchers(HttpMethod.POST, "/api/aulas").hasAnyRole("ADMIN", "ADMINISTRATIVO", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.PUT, "/api/aulas/**").hasAnyRole("ADMIN", "ADMINISTRATIVO", "SECRETARIO");
                    auth.requestMatchers(HttpMethod.DELETE, "/api/aulas/**").hasAnyRole("ADMIN");

                    auth.anyRequest().permitAll();
                })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(customUserDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
    }





}
