package com.Jean.Supermercado.config;

import com.Jean.Supermercado.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {




//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
//
//                return httpSecurity
//                        .csrf(csrf -> csrf.disable()) //proteccion para formulario
//                        .httpBasic(Customizer.withDefaults())
//                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                        .authorizeHttpRequests(http -> {
//
//                            // Configurar los endponts publicos
//                            http.requestMatchers(HttpMethod.GET, "/api/clientes/").permitAll();
//
//                            // Configurar los endpoints privados
//                            http.requestMatchers(HttpMethod.POST, "/api/clientes").hasAnyAuthority("CREATE"); //Configurar el resto de los endpoint - NO ESPECIFICADOS
//                            http.requestMatchers(HttpMethod.POST, "/api/clientes").hasAnyAuthority("DELETE");
//
//                            //Configurar el resto de endpoint - NO ESPECIFICADOS
//                            http.anyRequest().denyAll();
//                        })
//                        .build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
                .csrf(csrf -> csrf.disable()) //proteccion para formulario
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider (UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    /*@Bean
    public UserDetailsService userDetailsService(){
       List<UserDetails> userDetailsList = new ArrayList<>();

       userDetailsList.add(User.withUsername("jean")
               .password("123")
               .roles("ADMIN")
               .authorities("READ", "CREATE")
               .build());

        userDetailsList.add(User.withUsername("bruno")
                .password("123")
                .roles("User")
                .authorities("READ")
                .build());

        userDetailsList.add(User.withUsername("mati")
                .password("123")
                .roles("User")
                .authorities("READ")
                .build());

        return new InMemoryUserDetailsManager(userDetailsList);
    }*/



    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();

    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//    }
}
