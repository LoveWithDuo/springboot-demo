package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUserName(String name) {
		return userRepository.findByUserName(name);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
}
