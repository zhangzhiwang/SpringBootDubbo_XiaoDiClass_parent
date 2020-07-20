package com.asiainfo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.service.api.IHelloService;

@RestController
@RequestMapping("helloController")
public class HelloController {
	@Reference(version = "1.0.0", url = "dubbo://localhost:9090")
	private IHelloService helloService;

	@GetMapping("/sayHello")
	public String sayHello() {
		return helloService.hello();
	}
}
