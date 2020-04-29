package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.RedisUtil;

@Component
public class RedisTestComponent {
	@Autowired
	private RedisUtil redisUtil;
	public void testSave() {
		System.out.println(redisUtil);
		redisUtil.set("123","haha");
		redisUtil.set("456","123456");
	}
	public static void main(String[] args) {
		RedisTestComponent RedisTest = new RedisTestComponent();
		RedisTest.testSave();
	}
}
