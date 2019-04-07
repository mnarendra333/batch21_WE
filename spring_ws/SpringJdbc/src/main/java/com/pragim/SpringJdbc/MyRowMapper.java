package com.pragim.SpringJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MyRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User obj = new User();
		obj.setUsername(rs.getString(1));
		obj.setPassword(rs.getString(2));
		return obj;
	}

}
