package com.reyes.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reyes.tutorial.entity.User;
import com.reyes.tutorial.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id){
		return userMapper.getUserById(id);
	}
	
	@GetMapping("/user")
	public User getUser(User user){
		userMapper.insertUser(user);
		return user;
	}
}
