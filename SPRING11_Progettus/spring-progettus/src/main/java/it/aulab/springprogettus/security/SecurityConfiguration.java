package it.aulab.springprogettus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfiguration {
    
    // @Bean
    // public SecurityFilterChain configSecurityFilterChain(HttpSecurity hhtp) throws Exception {
    //     http.csrf().disable()
    //         authorize()HttpRequest()
    //         myReqeust().permitAll();
    // }

}
