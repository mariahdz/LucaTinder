package com.proyectos.grupo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LucatinderServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucatinderServidorApplication.class, args);
	}

}
