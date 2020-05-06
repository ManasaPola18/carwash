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

import com.pola.manasa.carwash.models.Customer;
import com.pola.manasa.carwash.models.CustCarDetails;

@Repository
public class CarWashDAO {

	Logger logger = LoggerFactory.getLogger(CarWashDAO.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String isValidUser(String email, String password) {
		logger.info("In isValidUser");
		String sql = "select User_TYPE,ID from customer where EMAIL_ID = ? and PASSWORD = ?";
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<String>() {

			@Override
			public String doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					return rs.getString(1)+"-"+rs.getString(2);
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
				userList.add("Select User");
				while(rs.next()) {
					userList.add(rs.getString(1));
				}
				return userList;
			}
		});
	}
	
	public Customer getUserDetails(String emailId) {
		logger.info("In getUserDetails");
		String sql = "SELECT ID, NAME, EMAIL_ID, PH_NUM, ADDRESS FROM customer where EMAIL_ID = ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Customer>() {

			@Override
			public Customer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1,emailId);
				
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt(1));
					customer.setName(rs.getString(2));
					customer.setEmailId(rs.getString(3));
					customer.setPhNum(rs.getString(4));
					customer.setAddress(rs.getString(5));
					return customer;
				}
				return null;
			}
		});
	}
	
	public Boolean addCarDetails(CustCarDetails car) {
		logger.info("In addCarDetails");
		String sql = "INSERT INTO cust_car_details (CUST_ID,  NUMBER, TYPE, COLOR, REGISTER_NUMBER, CAR_STATUS) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, car.getCustId());
				ps.setString(2, car.getCarNum());
				ps.setString(3, car.getCarType());
				ps.setString(4, car.getCarColor());
				ps.setString(5, car.getRegNum());
				ps.setString(6, car.getCarStatus());
				return ps.executeUpdate();
			}
			
		});
		return noOfRowsUpdated > 0;
	}
	
	public CustCarDetails getCarDetails(Integer id) {
		logger.info("In getCarDetails");
		String sql = "SELECT ID, CUST_ID, NUMBER, TYPE, COLOR,  REGISTER_NUMBER,  CAR_STATUS FROM cust_car_details "
				+ " where id = ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<CustCarDetails>() {

			@Override
			public CustCarDetails doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					CustCarDetails car = new CustCarDetails();
					car.setId(rs.getInt(1));
					car.setCustId(rs.getInt(2));
					car.setCarNum(rs.getString(3));
					car.setCarType(rs.getString(4));
					car.setCarColor(rs.getString(5));
					car.setRegNum(rs.getString(6));
					car.setCarStatus(rs.getString(7));
					return car;
				}
				return null;
			}
		});
	}
	
	public List<CustCarDetails> getListOfCars(Integer custId) {
		logger.info("In getListOfCars");
		String sql = "SELECT ID, CUST_ID, NUMBER, TYPE, COLOR,  REGISTER_NUMBER,  CAR_STATUS FROM cust_car_details "
				+ " where CUST_ID = ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<List<CustCarDetails>>() {

			@Override
			public List<CustCarDetails> doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setInt(1, custId);
				
				ResultSet rs = stmt.executeQuery();
				List<CustCarDetails> carsList = new ArrayList<>();
				while(rs.next()) {
					CustCarDetails car = new CustCarDetails();
					car.setId(rs.getInt(1));
					car.setCustId(rs.getInt(2));
					car.setCarNum(rs.getString(3));
					car.setCarType(rs.getString(4));
					car.setCarColor(rs.getString(5));
					car.setRegNum(rs.getString(6));
					car.setCarStatus(rs.getString(7));
					carsList.add(car);
				}
				return carsList;
			}
		});
	}
	
	public Boolean updateUserDetails(Customer customer) {
		logger.info("In updateUserDetails");
		String sql = "UPDATE customer SET NAME = ?, EMAIL_ID = ?, PH_NUM = ?, ADDRESS = ? WHERE ID = ?";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, customer.getName());
				stmt.setString(2, customer.getEmailId());
				stmt.setString(3, customer.getPhNum());
				stmt.setString(4, customer.getAddress());
				stmt.setInt(5, customer.getId());
				return stmt.executeUpdate();
			}
		});
		return noOfRowsUpdated > 0;
	}
}


