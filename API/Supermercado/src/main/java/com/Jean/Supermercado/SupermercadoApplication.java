package com.Jean.Supermercado;

import com.Jean.Supermercado.service.CustomUserDetailsService;
import com.Jean.Supermercado.service.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EntityScan(basePackages = "Entity")
@SpringBootApplication(scanBasePackages = "com.Jean.Supermercado")

public class SupermercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoApplication.class, args);
	}

	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig {

		@Autowired
		private CustomUserDetailsService userDetailsService;

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
					.csrf(csrf -> csrf.disable())  // Deshabilitar CSRF si es necesario
					.authorizeRequests(authz -> authz
							.requestMatchers(HttpMethod.POST, "/api/user").permitAll()  // Permitir acceso a /api/user sin autenticación
							.requestMatchers(HttpMethod.POST, "/api/login").permitAll() // Permitir acceso a /api/login sin autenticación
							.requestMatchers("/api/usuario/hola").hasAuthority("ROLE_USER")// Solo los usuarios con el rol ROLL_USER pueden acceder
							.requestMatchers("/api/usuario/tu").hasAuthority("ROLE_ADMIN")
							//.requestMatchers("/usu/**").hasAnyRole("USER", "ADMIN")  // Los roles USER y ADMIN pueden acceder a /usu/**
							.requestMatchers("/api/protegida").authenticated()  // Requiere autenticación
							.requestMatchers("/api/token-requerido").authenticated()  // Requiere autenticación
							.anyRequest().authenticated()  // Todas las demás rutas requieren autenticación
					)
					//.httpBasic(withDefaults())  // Habilita autenticación básica
					// Añadir cualquier otro filtro personalizado como JWT
					.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

			return http.build();
		}

		@Bean
		public JWTAuthorizationFilter JWTAuthorizationFilter() {

			return new JWTAuthorizationFilter ();
		}



	}

}
