package com.example.my_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( authHttp ->
                authHttp
                        .requestMatchers(HttpMethod.GET, "/authorized").permitAll()
                        .requestMatchers(HttpMethod.GET, "/home").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                        .requestMatchers(HttpMethod.GET, "/admin").permitAll()
                        .anyRequest().authenticated()
        )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
                .oauth2Client(Customizer.withDefaults())
                .oauth2ResourceServer(rs -> rs.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
