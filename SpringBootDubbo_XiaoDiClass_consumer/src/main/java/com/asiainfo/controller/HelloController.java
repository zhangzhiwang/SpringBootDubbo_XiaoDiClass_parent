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
//	@Reference(version = "1.0.0")// 如果用dubbo注解的方式来使用dubbo就不要用@Autowired，要用dubbo提供的@Reference注解，其中version的值要和服务提供者的version一致
	@Autowired// 如果要用xml配置的方式来使用dubbo就要用@Autowired
	private IHelloService helloService;

	@GetMapping("/sayHello")
	public String sayHello() throws InterruptedException {
		return helloService.hello();
	}
}
