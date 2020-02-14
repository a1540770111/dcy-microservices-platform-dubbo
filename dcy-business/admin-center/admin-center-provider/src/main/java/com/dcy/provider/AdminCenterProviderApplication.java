package com.dcy.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.dcy.provider.mapper"})
public class AdminCenterProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminCenterProviderApplication.class, args);
    }
}
