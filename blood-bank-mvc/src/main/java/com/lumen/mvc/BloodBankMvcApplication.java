package com.lumen.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blood Bank Management API",version = "1.0"))
public class BloodBankMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankMvcApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	public WebClient.Builder builder(){
		return WebClient.builder();
	}
	
	@Bean
	
	public WebClient client(WebClient.Builder buildRef) {
		return buildRef.build();
	}
	
}
