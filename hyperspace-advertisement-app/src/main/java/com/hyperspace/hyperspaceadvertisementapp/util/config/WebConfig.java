package com.hyperspace.hyperspaceadvertisementapp.util.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Dhanushka Paranavithana
 * @since 8/11/2021  2:12 AM
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings( CorsRegistry registry )
    {
        registry.addMapping( "/**" ).allowedOrigins( "*" ).allowedMethods( "GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

}
