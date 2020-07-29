package com.asiainfo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication
@ImportResource({"classpath:provider.xml"})
public class App {
	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
		new SpringApplicationBuilder(App.class).web(WebApplicationType.NONE).run();
	}
}