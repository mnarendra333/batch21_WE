package com.pragim.springrestwithhibjavaconfig.dao;

import java.util.List;

import com.pragim.springrestwithhibjavaconfig.model.User;

public interface UserDao {
	
	
	public List<User> getUserList();
	
	public String saveUser(User user);
	
	public String deleteUser(int id);
	
	public String updateUser(User user);

}
