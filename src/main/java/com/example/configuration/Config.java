package com.example.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Config {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }




}
