package com.example.bookstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


    

@Configuration
@EnableWebSecurity 
public class WebSecurityConfiguration{

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


    http
    .authorizeHttpRequests()
        .requestMatchers( "/book/.*").hasAnyRole("ADMIN", "USER")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
    return http.build();
}

}
