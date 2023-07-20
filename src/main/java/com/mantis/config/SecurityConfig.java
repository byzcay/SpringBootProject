package com.mantis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
 @Bean
 public BCryptPasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }

@Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
     return http
             .csrf(AbstractHttpConfigurer::disable)
             .authorizeHttpRequests(auth -> auth.requestMatchers("api/v1/auth/**").permitAll().anyRequest().permitAll()).build();
 }


}