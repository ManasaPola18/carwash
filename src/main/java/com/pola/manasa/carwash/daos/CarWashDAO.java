package com.pola.manasa.carwash.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.pola.manasa.carwash.models.Customer;

@Repository
public class CarWashDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Boolean isValidUser(String email, String password) {
		
		String sql = "select count(*) from customer where EMAIL_ID = ? and PASSWORD = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					int count = rs.getInt(1);
					return count > 0;
				}
				return false;
			}
		});
	}
	
	public Boolean customerSignUp(Customer customer) {
		
		String sql = "INSERT INTO customer ('ID','NAME','PASSWORD','EMAIL_ID','PH_NUM','ADDRESS') "
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, customer.getId());
				ps.setString(2, customer.getName());
				ps.setString(3, customer.getPassword());
				ps.setString(4, customer.getEmailId());
				ps.setString(5, customer.getPhNum());
				ps.setString(6, customer.getAddress());
				return ps.executeUpdate();
			}
			
		});
		return noOfRowsUpdated > 0;
	}
	
}
