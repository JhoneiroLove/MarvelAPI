package com.test.api.marvelreto.security;

import com.test.api.marvelreto.web.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * La clase `WebSecurity` configura la seguridad de la aplicación mediante Spring Security.
 * Se habilita la autenticación basada en tokens JWT, se deshabilita CSRF y se configuran reglas de autorización.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurity {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Configura la cadena de filtros de seguridad.
     *
     * @param http El objeto `HttpSecurity` que se configura para establecer políticas de seguridad.
     * @return La cadena de filtros de seguridad configurada.
     * @throws Exception Si se produce una excepción durante la configuración.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf( config -> config.disable() )
                .sessionManagement( config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
