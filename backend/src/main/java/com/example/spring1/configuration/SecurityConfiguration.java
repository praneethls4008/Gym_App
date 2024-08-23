package com.example.spring1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*antMatchers("/public/**").permitAll()  // Public endpoints
        .antMatchers("/private/**").authenticated()*/
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(request -> request
                        .anyRequest().permitAll()).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
