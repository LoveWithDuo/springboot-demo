package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>{
	
	User findByUserName(String userName);//按照名字查询
}
