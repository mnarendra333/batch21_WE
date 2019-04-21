package com.pragim.springmvcjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pragim.springmvcjdbc.model.Flight;

public class FlightDaoImpl implements FlightDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public FlightDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Flight> getFlightList() {
		return jdbcTemplate.query("select * from flights", new RowMapper<Flight>() {

			@Override
			public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Flight obj = new Flight();
				obj.setFlightId(rs.getInt(2));
				obj.setFlightName(rs.getString(3));
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date format = null;
				try {
					format = sdf.parse(rs.getString("FLIGHT_TIME_DEP"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Date dd=rs.getDate("FLIGHT_TIME_DEP");
				obj.setDepartureTime(format);
				//Double d=rs.getDouble("FLIGHT_FARE");
				
				obj.setCost(rs.getDouble(5));
				return obj;
			}
		});
		
	}

}
