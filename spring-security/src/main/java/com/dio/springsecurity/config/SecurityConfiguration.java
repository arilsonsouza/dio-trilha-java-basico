package com.dio.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dio.springsecurity.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = { "/", "/login", "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html" };

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    @Order(1)
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider())
                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/users/**").hasAnyRole("USERS", "MANAGERS")
                        .anyRequest().hasRole("MANAGERS"))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws
    // Exception {
    // http
    // .authorizeHttpRequests(authorize -> authorize
    // .requestMatchers(WHITE_LIST_URL).permitAll()
    // .requestMatchers("/img/*.jpg", "/*.js", "/*.css").permitAll()
    // .requestMatchers("/managers/**").hasAnyRole("MANAGERS")
    // .requestMatchers("/users/**").hasAnyRole("USERS", "MANAGERS")
    // .anyRequest().authenticated())
    // .formLogin(Customizer.withDefaults())
    // // .formLogin((form) -> form
    // // .loginPage("/login")
    // // .permitAll())
    // .logout((logout) -> logout.permitAll());
    // return http.build();
    // }
}
