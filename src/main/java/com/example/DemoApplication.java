package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.test.AopDemo;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DemoApplication.class);
//    }
//	public DemoApplication(AopDemo aopDemo) {
//		String uuid = aopDemo.randUUID();
//		System.out.println(uuid);
//	} 

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		RedisTestComponent redisTestComponent = context.getBean(RedisTestComponent.class); 
//		redisTestComponent.testSave();
		
	}
}
