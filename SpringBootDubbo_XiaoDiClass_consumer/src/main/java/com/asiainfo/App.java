package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:consumer.xml"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
