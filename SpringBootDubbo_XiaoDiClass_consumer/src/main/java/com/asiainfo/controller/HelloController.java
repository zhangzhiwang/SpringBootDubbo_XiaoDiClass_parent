package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.service.api.IHelloService;

@RestController
@RequestMapping("helloController")
public class HelloController {
//	@Ref
	private IHelloService helloService;

	@GetMapping("/sayHello")
	public String sayHello() {
		return helloService.hello();
	}
}
