package com.pragim.springrestwithhibjavaconfig.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pragim.springrestwithhibjavaconfig.dao.UserDao;
import com.pragim.springrestwithhibjavaconfig.model.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping(value="/list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUserList(){
		return dao.getUserList();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> saveUser(@RequestBody User user){
		Map<String,String> map = new HashMap<String, String>();
		String saveUser = null;
		if(user.getId()!=0)
			saveUser = dao.updateUser(user); 
		else
			saveUser = dao.saveUser(user);
		map.put("message", saveUser);
		return map;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String,String> getUserList(@PathVariable("id") String id){
		Map<String,String> map = new HashMap<String, String>();
		map.put("message",dao.deleteUser(Integer.parseInt(id)));
		return map;
	}

}
