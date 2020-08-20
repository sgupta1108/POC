package com.springboot.mindtree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Appmain {

	public static void main(String[] args) {
		SpringApplication.run(Appmain.class, args);
	}
}
