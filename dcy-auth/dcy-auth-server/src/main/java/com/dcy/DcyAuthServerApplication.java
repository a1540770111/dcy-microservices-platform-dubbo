package com.dcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author dcy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DcyAuthServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DcyAuthServerApplication.class, args);
        for (int i = 0; i < run.getBeanDefinitionNames().length; i++) {
            System.out.println(run.getBeanDefinitionNames()[i]);
        }
    }
}
