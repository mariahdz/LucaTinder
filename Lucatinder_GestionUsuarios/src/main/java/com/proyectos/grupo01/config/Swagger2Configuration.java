//package com.proyectos.grupo01.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//
//import java.util.Collections;
///**
// * Swagger 2 Cofiguration <br>
// * @author Desiree
// * @version 30/07/2021/A
// *
// */
//@EnableSwagger2
//@Configuration
//public class Swagger2Configuration {
//
//	//http://localhost:3333/swagger-ui.html#/
//	
//	 @Bean
//	   public Docket productApi() {
//	       return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.any())
//					.paths(PathSelectors.any())
//					.build()
//					.apiInfo(getApiInfo());
//	    }
//	 
//	 private ApiInfo getApiInfo() {
//			return new ApiInfo(
//					"Order Service API", 
//					"Order Service API Description", 
//					"1.0", "http://lucaTinder.es/terms",
//					new Contact(
//							"LucaTinder - project", 
//							"projects", 
//							"projects@lucaTinder.es"), 
//					"LICENSE", 
//					"LICENSE URL",
//					Collections.emptyList());
//		}
//
//
//}
