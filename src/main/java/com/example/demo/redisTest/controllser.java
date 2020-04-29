package com.example.demo.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.RedisUtil;

@RestController
@RequestMapping("/user")
public class controllser {
	
	@Autowired
	private RedisUtil redisUtil;
	@GetMapping("/updateRank")
	public Boolean updateRank(Long userId, Float score) {
		// 因为zset默认积分小的在前面，所以我们对score进行取反，这样用户的积分越大，对应的score越小，排名越高
		Boolean zSSet = redisUtil.zSSet("RANK", userId, -score);
		
		return zSSet;
		
	}
	
	
		
	   
}
