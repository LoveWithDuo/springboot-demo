package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

public class ThreadTest implements Runnable{
	private User user;
	public ThreadTest (User user) {
		this.user = user;
	}
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run() {
		userRepository.save(user);
		System.out.println("++++++++添加成功+++++++++++++++");
	}

	
}
