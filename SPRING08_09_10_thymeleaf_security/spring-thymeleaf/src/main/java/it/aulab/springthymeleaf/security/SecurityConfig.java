package it.aulab.springthymeleaf.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public InMemoryUserDetailsManager createUserDetails() {
        UserBuilder user = User.withUsername("user").password(encoder().encode("password")).roles("USER");
        UserBuilder admin = User.withUsername(encoder().encode("admin")).password("admin").roles("ADMIN");

        return new InMemoryUserDetailsManager(user.build(), admin.build());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
        .requestMatchers("/api/**").permitAll()
        .requestMatchers("/authors/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login")
            .loginProcessingUrl("/login").defaultSuccessUrl("/authors/all").permitAll()
            .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll()
            .and().httpBasic()
            .and().csrf().ignoringRequestMatchers("/api/**")
            .and().headers().xssProtection()
            .and().contentSecurityPolicy("style.src 'self' *.googleapis.com cd.jsdeliver.net cdnjs.c; script-src 'self' ");
        return http.build();
    }
}

//gestire autenticazione http-> specificarePath -> policy -> specificare al filtro di gestire il resto delle richieste -> csrf -> xssProtection(headers) -> gestire collegamenti a siti esterni  --> build()

//credenziali -> InMemoryDetailsUserManager ( vedi appunti)
//encoder -> Bcrypt ( vs SHA-256)