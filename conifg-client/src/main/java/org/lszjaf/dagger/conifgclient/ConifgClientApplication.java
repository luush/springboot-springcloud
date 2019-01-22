package org.lszjaf.dagger.conifgclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConifgClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConifgClientApplication.class, args);
    }

}

