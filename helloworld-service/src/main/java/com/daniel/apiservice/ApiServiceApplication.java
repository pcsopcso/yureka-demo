package com.daniel.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}
	
	@RefreshScope
	@RestController
	class MessageRestController {

	   @Value("${message}")
	   private String message;

	   @Value("${eureka.instance.metadataMap.instanceId}")
	   private String instanceId;

	   @RequestMapping("/")
	   String message() {
	      return this.message;
	   }

	   @RequestMapping("/id")
	   String instanceId() { return this.instanceId; }
	}
}
