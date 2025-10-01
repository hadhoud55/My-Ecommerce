package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthEntryPoint authEntryPoint;
    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(JwtAuthEntryPoint authEntryPoint, JwtTokenFilter jwtTokenFilter) {
        this.authEntryPoint = authEntryPoint;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF (needed for stateless API)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/**", "/h2-console/**", "/contact/messages*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/products/**").permitAll() // Allow public access to GET /products
                        .requestMatchers(HttpMethod.POST, "/products/**").hasRole("ADMIN") // Only ADMIN can create products
                        .requestMatchers(HttpMethod.PUT, "/products/**").hasRole("ADMIN") // Only ADMIN can update products
                        .requestMatchers(HttpMethod.DELETE, "/products/**").hasRole("ADMIN") // Only ADMIN can delete products
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("ADMIN", "USER") // Both ADMIN and USER can get user details
                        .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN") // Only ADMIN can update user details
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                        .requestMatchers(   "/contact/messages/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint))
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
