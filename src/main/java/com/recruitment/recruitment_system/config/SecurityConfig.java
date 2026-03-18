package com.recruitment.recruitment_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())

                // 🔥 VERY IMPORTANT: allow everything
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // ❌ REMOVE BASIC AUTH (this was causing 401)
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        // ✅ Allow ALL origins (correct way)
        configuration.setAllowedOriginPatterns(List.of("*"));

        // ✅ Allow ALL HTTP methods
        configuration.setAllowedMethods(List.of("*"));

        // ✅ Allow ALL headers
        configuration.setAllowedHeaders(List.of("*"));

        // ✅ Allow credentials (cookies, auth headers)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}