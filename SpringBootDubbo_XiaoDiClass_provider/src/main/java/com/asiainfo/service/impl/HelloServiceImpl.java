package com.asiainfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

//import org.apache.dubbo.config.annotation.Service;

import com.asiainfo.service.api.IHelloService;

@Service(version = "1.0.0")
public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello() {
		return "Hello World!";
	}

}
