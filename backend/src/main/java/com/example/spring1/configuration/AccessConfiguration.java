package com.example.spring1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AccessConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(request -> {
                    request.requestMatchers("/access/").permitAll();
                    request.requestMatchers("/access/user/**").hasRole("USER");
                    request.requestMatchers("/access/admin/**").hasRole("ADMIN");
                    request.anyRequest().denyAll();
                }
        )
                .formLogin(form->form.permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.builder()
                .username("username1")
                .password("{noop}username1")
                .roles("USER")
                .build();

        UserDetails adminDetails = User.builder()
                .username("username2")
                .password("{noop}username2")
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails,adminDetails);
    }


}
