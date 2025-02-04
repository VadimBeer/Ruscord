package org.example.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.example.backend")
@PropertySource("classpath:application.properties")
public class Config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/ruscordRegistration/*")  // Разрешаем доступ к любому API, начинающемуся с /api
                .allowedOrigins("http://127.0.0.1:5500")  // Разрешаем только запросы с этого фронтенда
                .allowedMethods("GET", "POST", "PUT", "DELETE");  // Разрешаем GET, POST, PUT, DELETE
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Замените абсолютный путь на путь к вашей папке с фронтендом
        registry.addResourceHandler("/**")
                .addResourceLocations("file:/html/scss/login/");
    }
}