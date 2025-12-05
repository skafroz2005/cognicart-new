package com.cognicart.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class , args);
    }
}

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//
//@SpringBootApplication
//// @EnableEurekaClient
//public class ProductServiceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ProductServiceApplication.class, args);
//    }
//
//}