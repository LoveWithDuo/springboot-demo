package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.test.ThreadTest;

@RestController

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/findByUserName")
	@ResponseBody
	public Object findByUserName(@RequestBody JSONObject json) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String name = json.getString("name");
			User user = userService.findByUserName(name);
			resultMap.put("user", user);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			e.printStackTrace();
		}
		return resultMap;
		
	}
	@GetMapping("/addUser")
	@ResponseBody
	public Object addUser(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			User user = new User();
			user.setUserName(name);
			user.setPassword(password);
			userService.save(user);
			Optional<User> findById = userService.findById(user.getId());
			resultMap.put("user", findById);
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			e.printStackTrace();
		}
		return resultMap;
		
	}
	
	@PostMapping("/saveUserName")
	@ResponseBody
	@Transactional
	public Object saveUserName(@RequestBody JSONObject json) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//创建线程池
//		ExecutorService es = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
		ExecutorService es = Executors.newFixedThreadPool(10);
		try {
			for (int i = 0; i < 10; i++) {
				String uuid = UUID.randomUUID().toString();
				User user = new User();
				user.setUserName(i+"");
				user.setPassword(uuid.substring(0, 2));
				es.execute(new Runnable() {
					@Override
					public void run() {
						userService.save(user);
						System.out.println("thread:"+Thread.currentThread().getName());
					}
				});
			}
			resultMap.put("result", 1);
		} catch (Exception e) {
			resultMap.put("result", 0);
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
		} finally {
			es.shutdown();
		}
		return resultMap;
		
	}
}
