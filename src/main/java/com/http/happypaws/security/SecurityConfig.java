package com.http.happypaws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}
	
    @Bean
    //@Bean le dice a Spring: "Oye, crea y maneja este objeto por mí, ¿vale?" :)
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
    	return new JwtAuthenticationFilter();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @SuppressWarnings("removal")
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(handling -> handling
                .authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests()
                .requestMatchers("api/auth/**").permitAll()
                .requestMatchers("api/user/edit/**").permitAll()
                .requestMatchers("api/user/**").permitAll()
                .requestMatchers("api/another/donation").permitAll()
                .requestMatchers("api/another/send/adoptation").permitAll()
                .requestMatchers("api/another/send/contact").permitAll()
                //.requestMatchers("api/protectora/all").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/user/validate/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/openai/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.POST, "/api/protectora/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.GET, "/api/protectora/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.POST, "/api/eventos/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.GET, "/api/eventos/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.POST, "/api/mascota/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.GET, "/api/mascota/**").hasAnyAuthority("Gestor", "Voluntario")
                .requestMatchers(HttpMethod.POST, "/api/mail/**").hasAnyAuthority("Gestor", "Voluntario")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
                http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
                return http.build();
                		
    }
	
}
