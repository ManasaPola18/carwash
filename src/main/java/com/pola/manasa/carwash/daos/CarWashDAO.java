package com.pola.manasa.carwash.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.pola.manasa.carwash.controllers.CarWashController;
import com.pola.manasa.carwash.models.Customer;

@Repository
public class CarWashDAO {

	Logger logger = LoggerFactory.getLogger(CarWashDAO.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String isValidUser(String email, String password) {
		logger.info("In isValidUser");
		String sql = "select User_TYPE from customer where EMAIL_ID = ? and PASSWORD = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<String>() {

			@Override
			public String doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1);
				}
				return "";
			}
		});
	}

	
	public Boolean customerSignUp(Customer customer) {
		logger.info("In customerSignUp");
		String sql = "INSERT INTO customer (NAME,PASSWORD,EMAIL_ID,PH_NUM,ADDRESS, USER_TYPE) "
				+ " VALUES (?, ?, ?, ?, ?,?)";

		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, customer.getName());
				ps.setString(2, customer.getPassword());
				ps.setString(3, customer.getEmailId());
				ps.setString(4, customer.getPhNum());
				ps.setString(5, customer.getAddress());
				ps.setString(6, customer.getUserType());
				return ps.executeUpdate();
			}
			
		});
		return noOfRowsUpdated > 0;
	}
	
	public List<String> getCustomerDetails(String userType){
		logger.info("In getCustomerDetails");
		String sql = "Select EMAIL_ID from customer where USER_TYPE = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<List<String>>() {
			
			@Override
			public List<String> doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1,userType);
				ResultSet rs = stmt.executeQuery();
				List<String> userList = new ArrayList<>();
				while(rs.next()) {
					userList.add(rs.getString(1));
				}
				return userList;
			}
		});

	}
	
	/*
	 * public List<String> getOrderDetails(String orders){
	 * logger.info("In getOrderDetails"); String sql = "Select  " }
	 */
	
	
}


