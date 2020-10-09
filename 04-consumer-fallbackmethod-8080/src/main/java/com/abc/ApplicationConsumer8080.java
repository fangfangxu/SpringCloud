package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

//@SpringBootApplication
@SpringCloudApplication
public class ApplicationConsumer8080 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsumer8080.class, args);
    }

}
