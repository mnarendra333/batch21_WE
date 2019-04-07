package com.pragim.SpringJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SpringJdbcDemo {

	private JdbcTemplate jt;

	public SpringJdbcDemo(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	
	public void executeStaticQuery(){
		jt.execute("insert into userlist values('kumar','kumar')");
	}
	
	public void updateQueries(){
		jt.update("insert into userlist values(?,?)","raja","raja");
		
		//jt.update("insert into userlist values(?,?)");
	}
	
	public void queryMethods(){
		
		List<Map<String, Object>> queryForList = jt.queryForList("select * from userlist");
		System.out.println(queryForList);
	}
	
	
	public void mapThroughResultSetExtractor(){
		
		List<User> list = jt.query("select * from userlist", new ResultSetExtractor<List<User>>() {

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<User> userlist = new ArrayList<User>();
				while (rs.next()) {
					User obj = new User();
					obj.setUsername(rs.getString(1));
					obj.setPassword(rs.getString(2));
					userlist.add(obj);
				}
				
				return userlist;
			}
		});
		System.out.println(list);
	}
	
	
	public void rowMapper(){
		
		List<User> query = jt.query("select * from userlist", new MyRowMapper());
		System.out.println(query);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		SpringJdbcDemo demo = ctx.getBean("id1",SpringJdbcDemo.class);
		//demo.executeStaticQuery();
		//demo.updateQueries();
		//demo.queryMethods();
		//demo.mapThroughResultSetExtractor();
		demo.rowMapper();
		
	}

}
