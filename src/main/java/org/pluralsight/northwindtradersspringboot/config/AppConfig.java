package org.pluralsight.northwindtradersspringboot.config;

import org.pluralsight.northwindtradersspringboot.dao.SimpleProductDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SimpleProductDAO product() {
        return new SimpleProductDAO();
    }

}
