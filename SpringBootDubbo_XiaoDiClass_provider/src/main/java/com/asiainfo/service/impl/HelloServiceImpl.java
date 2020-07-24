package com.asiainfo.service.impl;

import org.springframework.stereotype.Service;
//import org.apache.dubbo.config.annotation.Service;
import com.asiainfo.service.api.IHelloService;

//@Service(version = "1.0.0")// 注意如果要用注解的方式使用dubbo的话这里是dubbo的service注解，version为服务的版本号
//@Service// 如果要用xml配置的方式使用dubbo那么这里是spring的service注解，或者不实用注解直接在xml里面配置本类的bean
public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello() throws InterruptedException {
		System.out.println("hello服务");
		Thread.sleep(10000);
		return "Hello World!";
	}

}
