package com.asiainfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private ZkLock zkLock;
	
	@GetMapping("/test")
	public void test() {
		for(int i = 0; i < 1000; i++) {
			zkLock.lock();
			System.out.println(i);
			int count = testMapper.getCountById(1);
			testMapper.update(count + 1);
			zkLock.unlock();
		}
	}
}
