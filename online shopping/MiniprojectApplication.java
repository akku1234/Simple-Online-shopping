package com.llts.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}
}
 