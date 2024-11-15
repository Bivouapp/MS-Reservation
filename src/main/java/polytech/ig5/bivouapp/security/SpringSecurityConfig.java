package polytech.ig5.bivouapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // .csrf().disable() // Disable CSRF since this is a stateless API
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
                // .anyRequest().authenticated() // Require authentication for all endpoints
            );
            // .oauth2ResourceServer() // Enable OAuth2 Resource Server for JWT authentication
            // .jwt(); // Enable JWT as the token type

        return http.build();
    }

    // @Bean
    // public JwtAuthenticationConverter jwtAuthenticationConverter() {
    //     JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
    //     // Add custom logic here if needed (like role extraction from JWT claims)
    //     return converter;
    // }
}
