package com.ptm.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.ptm.login")
public class PtmLoginApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(PtmLoginApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PtmLoginApplication.class);
	}
	
}
