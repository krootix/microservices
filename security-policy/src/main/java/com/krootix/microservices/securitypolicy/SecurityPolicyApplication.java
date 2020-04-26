package com.krootix.microservices.securitypolicy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.krootix.microservices.securitypolicy")
@EnableDiscoveryClient
@EnableCaching
public class SecurityPolicyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityPolicyApplication.class, args);
    }

}
