package com.reyes.tutorial.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.reyes.tutorial.entity.User;

@Mapper
public interface UserMapper {
	
	public User getUserById(Integer id);
	
	public int insertUser(User user);

}
