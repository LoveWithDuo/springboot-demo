package com.example.demo.test;

import java.util.Date;
import java.util.UUID;

public class AopDemo {
	
	public String randUUID() {
		String uuid = null;
		try {
			
			uuid = UUID.randomUUID() + "|" + new Date();
			System.out.println(uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uuid;
	}
	
}
