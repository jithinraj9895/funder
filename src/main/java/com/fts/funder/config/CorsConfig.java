package com.fts.funder.config;
import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Only allow trusted frontend domains (NO wildcard `*` in production)
        config.setAllowedOrigins(List.of("http://localhost:4200"));

        // ✅ Allow only necessary HTTP methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Allow only required headers (Avoid `*`)
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));

        // ✅ Allow credentials if using authentication (e.g., JWT, sessions)
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}


