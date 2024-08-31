package com.example.spring1.configuration;

import com.example.spring1.service.UserDetailsAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration{

    @Autowired
    UserDetailsAuthService userDetailsAuthService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        return http.authorizeHttpRequests(request -> {
            request.requestMatchers("/user").hasRole("OWNER");
            request.requestMatchers("/video").hasRole("REGISTERED_USER");
            request.anyRequest().permitAll();
        })
                .formLogin(form -> form
                        .loginPage("/signin")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .build();

    }

    @Bean
    UserDetailsService userDetailsService(){
        return userDetailsAuthService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsAuthService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }






}
