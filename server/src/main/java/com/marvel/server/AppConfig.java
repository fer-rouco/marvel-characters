package com.marvel.server;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marvel.api.client.MarvelApiClient;

@Configuration
public class AppConfig {
    @Bean
    public MarvelApiClient MarvelApiClient() {
        return new MarvelApiClient();
    }
    
    @Bean
    public ModelMapper ModelMapper() {
        ModelMapper mapper = new ModelMapper();
        // mapper.getConfiguration().addValueReader(new JsonElementValueReader());
        return mapper;
    }
}
