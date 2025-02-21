package com.hospitalmanagementsystem.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login").permitAll() // Allow public access
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/doctor/**").hasRole("DOCTOR")
                        .requestMatchers("/nurse/**").hasRole("NURSE")
                        .requestMatchers("/receptionist/**").hasRole("RECEPTIONIST")
                        .requestMatchers("/lab/**").hasRole("LAB_TECHNICIAN")
                        .requestMatchers("/pharmacy/**").hasRole("PHARMACIST")
                        .requestMatchers("/patient/**").hasRole("PATIENT")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.defaultSuccessUrl("/dashboard", true))
                .httpBasic(httpBasic -> {});
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        UserDetails doctor = User.builder()
                .username("doctor")
                .password(passwordEncoder.encode("password"))
                .roles("DOCTOR")
                .build();

        UserDetails nurse = User.builder()
                .username("nurse")
                .password(passwordEncoder.encode("password"))
                .roles("NURSE")
                .build();

        UserDetails receptionist = User.builder()
                .username("receptionist")
                .password(passwordEncoder.encode("password"))
                .roles("RECEPTIONIST")
                .build();

        UserDetails labTech = User.builder()
                .username("lab")
                .password(passwordEncoder.encode("password"))
                .roles("LAB_TECHNICIAN")
                .build();

        UserDetails pharmacist = User.builder()
                .username("pharmacist")
                .password(passwordEncoder.encode("password"))
                .roles("PHARMACIST")
                .build();

        UserDetails patient = User.builder()
                .username("patient")
                .password(passwordEncoder.encode("password"))
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, doctor, nurse, receptionist, labTech, pharmacist, patient);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
