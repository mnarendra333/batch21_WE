package com.pragim.springrestwithhibjavaconfig.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pragim.springrestwithhibjavaconfig.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		Session session = factory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	@Override
	public String saveUser(User user) {
		Session session = factory.getCurrentSession();
		Integer res = (Integer)session.save(user);
		if(res>0)
			return "User added successfully";
		else
			return "User not added";
	}

	@Override
	public String deleteUser(int id) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, id);
		String message="User does not exist in DB!!";
		if(user!=null){
			session.delete(user);
			message = "User deleted!!!";
		}
		return message;
	}

	@Override
	public String updateUser(User userObj) {
		Session session = factory.getCurrentSession();
		String message="User does not exist in DB!!";
		
		User usrDB = session.get(User.class, userObj.getId());
		if(usrDB!=null){
			if(userObj.getName()!=null)
				usrDB.setName(userObj.getName());
			if(userObj.getAddr()!=null)
				usrDB.setAddr(userObj.getAddr());
			session.update(usrDB);
			message = "User Updated!!!";
		}
		return message;
	}

}
