package es.dsw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//DOCUMENTACIÓN DE REFERENCIA:
		//https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html
		
		http 
		.authorizeHttpRequests((authorize) -> authorize
			    .requestMatchers("/img/**").permitAll() 
				.requestMatchers("/styles/**").permitAll()
				.requestMatchers("/js/**").permitAll()
				.requestMatchers("/jquery/**").permitAll()
				.requestMatchers("/ayuda").permitAll() 
				.anyRequest().authenticated() 
		)
		.httpBasic(withDefaults()) 
		.formLogin(form -> form    
				.loginPage("/loggin") 
				.loginProcessingUrl("/logginprocess")
				.permitAll() 	
			);
		
		return http.build();
	}

	@Bean
	InMemoryUserDetailsManager userDetailsService() {
	
		@SuppressWarnings("deprecation")
		UserDetails user1 = User.withDefaultPasswordEncoder()
		    .username("pepito")
            .password("1234")   
            .roles("usuario")
            .build();
		
		//Se declara un objeto InMemoryUserDetailsManager para añadir los usuarios de la aplicación
		InMemoryUserDetailsManager InMemory;
		
        //Se crea un objeto InMemoryUserDetailsManager que nos permitirá cargar los usuarios en memoria de aplicación.
        InMemory = new InMemoryUserDetailsManager();
        
        //Se cargan los usuarios.
        InMemory.createUser(user1);
       
        //Se devuelve a el modulo de Spring Security el descriptor del objeto InMemoryUserDetailsManager para que surta efecto las modificaciones.
        return InMemory;
		
	}
	
	
   
    



}