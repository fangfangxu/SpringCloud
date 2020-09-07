package com.abc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartCodeConfigure {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
