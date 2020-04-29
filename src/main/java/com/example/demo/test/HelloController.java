package com.example.demo.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.CommonResult;
import com.example.common.RedisUtil;

@RestController
@RequestMapping("/user")
public class HelloController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private RedisUtil redisUtil;
	@PostMapping("/hello")
	public Object hello() {
		return "hello world";
	}
	
	@PostMapping("redisTest")
	public CommonResult<?> redisTest() {
		try {
			redisUtil.set("key","value");
			redisUtil.set("ming","blue");
			
			return CommonResult.success(null);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed("操作失败");
			
		}
	}
	@PostMapping("redisGetTest")
	public CommonResult redisGetTest() {
		try {
//			Object object = redisUtil.get("key");
//			String jsonString = JSONObject.toJSONString(object); 
//			System.out.println(jsonString);
//			boolean hasKey = redisUtil.hasKey("key");
			List<Object> objList = new ArrayList<Object>();
			objList.add("456");
			boolean lSet = redisUtil.lSet("list", objList);
			return CommonResult.success(lSet);
		} catch (Exception e) {
			e.printStackTrace();
			return CommonResult.failed("操作失败");
		}
	}
	
	
	@GetMapping("getTest")
	public String getTest(HttpServletRequest request) {
		try {
			 String name = request.getParameter("name");
			 String password = request.getParameter("password");
			return "name :"+request.getParameter("name")+"password :"+request.getParameter("password");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
}
