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

import com.pola.manasa.carwash.models.CustCarDetails;
import com.pola.manasa.carwash.models.Customer;
import com.pola.manasa.carwash.models.WashCosts;
import com.pola.manasa.carwash.models.WashPackage;

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
	
	public Customer customerSignUp(Customer customer) {
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
		
		if (noOfRowsUpdated > 0) {
			return getUserDetails(customer.getEmailId());
		}
		return null;
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
	
	public Boolean updateCarDetails(CustCarDetails car) {
		logger.info("In updateCarDetails");
		String sql = "UPDATE cust_car_details SET NUMBER = ?, TYPE = ?, COLOR = ?, REGISTER_NUMBER = ?, CAR_STATUS = ? " + 
				" WHERE ID = ?";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, car.getCarNum());
				stmt.setString(2, car.getCarType());
				stmt.setString(3, car.getCarColor());
				stmt.setString(4, car.getRegNum());
				stmt.setString(5, car.getCarStatus());
				stmt.setInt(6, car.getId());

				return stmt.executeUpdate();
			}

		});
		return noOfRowsUpdated > 0;
	}
	
	public List<WashCosts> getListOfWashCosts(String type) {
		logger.info("In getListOfWashCosts Type "+type);
		String sql = "SELECT ID, NAME, COST FROM wash_costs where TYPE= ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<List<WashCosts>>() {

			@Override
			public List<WashCosts> doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, type);
			
				ResultSet rs = stmt.executeQuery();
				List<WashCosts> list = new ArrayList<>();
				while(rs.next()) {
					WashCosts washCost = new WashCosts();
					washCost.setId(rs.getInt(1));
					washCost.setName(rs.getString(2));
					washCost.setCost(rs.getInt(3));
					list.add(washCost);
				}
				return list;
			}
		});
	}
	
	public Boolean updateWashCostDetails(WashCosts cost) {
		logger.info("In updateWashCostDetails");
		String sql = "UPDATE wash_costs SET NAME = ?, COST = ? WHERE ID = ?";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, cost.getName());
				stmt.setInt(2, cost.getCost());
				stmt.setInt(3, cost.getId());
				return stmt.executeUpdate();
			}

		});
		return noOfRowsUpdated > 0;
	}
	
	public WashCosts getWashCosts(Integer id) {
		logger.info("In getWashCosts");
		String sql = "SELECT ID, NAME, COST, TYPE FROM wash_costs where ID= ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<WashCosts>() {

			@Override
			public WashCosts doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setInt(1, id);
			
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					WashCosts washCost = new WashCosts();
					washCost.setId(rs.getInt(1));
					washCost.setName(rs.getString(2));
					washCost.setCost(rs.getInt(3));
					washCost.setType(rs.getString(3));
					return washCost;
				}
				return null;
			}
		});
	}
	
	public WashCosts getWashCosts(String name, Integer cost, String type) {
		logger.info("In getWashCosts");
		String sql = "SELECT ID, NAME, COST, TYPE FROM wash_costs where NAME = ? and COST = ? and type = ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<WashCosts>() {

			@Override
			public WashCosts doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, name);
				stmt.setInt(2, cost);
				stmt.setString(3, type);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					WashCosts washCost = new WashCosts();
					washCost.setId(rs.getInt(1));
					washCost.setName(rs.getString(2));
					washCost.setCost(rs.getInt(3));
					washCost.setType(rs.getString(3));
					return washCost;
				}
				return null;
			}
		});
	}
	
	public WashCosts saveWashCostDetails(WashCosts cost) {
		logger.info("In saveWashCostDetails");
		String sql = "INSERT INTO wash_costs (NAME, COST, TYPE) VALUES (?, ?, ?)";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setString(1, cost.getName());
				stmt.setInt(2, cost.getCost());
				stmt.setString(3, cost.getType());
				return stmt.executeUpdate();
			}
		});
		if (noOfRowsUpdated > 0) {
			return getWashCosts(cost.getName(), cost.getCost(), cost.getType());
		}
		return null;
	}
	
	public WashPackage saveWashPackageDetails(WashPackage pack) {
		logger.info("In saveWashPackageDetails");
		String sql = "INSERT INTO wash_package (SERVICE_ID, PACKAGE_NAME, ADD_ON_IDS, TOTAL_COST, DISCOUNT, DISCOUNTED_COST, STATUS) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setInt(1, pack.getServiceId());
				stmt.setString(2, pack.getPackageName());
				stmt.setString(3, pack.getAddOnId());
				stmt.setFloat(4, pack.getTotalCost());
				stmt.setFloat(5, pack.getDiscount());
				stmt.setFloat(6, pack.getDiscountCost());
				stmt.setString(7, pack.getStatus());
				return stmt.executeUpdate();
			}
		});
		if (noOfRowsUpdated > 0) {
			return getPackages(pack.getPackageName()).get(0);
		}
		return null;
	}
	
	public Boolean updateWashPackageDetails(WashPackage pack) {
		logger.info("In updateWashPackageDetails");
		String sql = "UPDATE wash_package SET SERVICE_ID = ?, PACKAGE_NAME = ?, ADD_ON_IDS = ?, TOTAL_COST = ?,"
				+ " DISCOUNT = ?, DISCOUNTED_COST = ? WHERE ID = ?";
		
		int noOfRowsUpdated = jdbcTemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				stmt.setInt(1, pack.getServiceId());
				stmt.setString(2, pack.getPackageName());
				stmt.setString(3, pack.getAddOnId());
				stmt.setFloat(4, pack.getTotalCost());
				stmt.setFloat(5, pack.getDiscount());
				stmt.setFloat(6, pack.getDiscountCost());
				stmt.setInt(7, pack.getId());
				return stmt.executeUpdate();
			}
		});
		return noOfRowsUpdated > 0;
	}
	
	public List<WashPackage> getPackages(String packageName) {
		logger.info("In getPackages");
		String sql = "SELECT ID, SERVICE_ID, PACKAGE_NAME, ADD_ON_IDS, TOTAL_COST, DISCOUNT, DISCOUNTED_COST "
				+ " FROM wash_package ";
		if (packageName!= null && packageName != "") {
			sql+= "where PACKAGE_NAME = '"+packageName+"'";
		}
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<List<WashPackage>>() {

			@Override
			public List<WashPackage> doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
				ResultSet rs = stmt.executeQuery();
				List<WashPackage> packageList = new ArrayList<>();
				while(rs.next()) {
					WashPackage pack = new WashPackage();
					pack.setId(rs.getInt(1));
					pack.setServiceId(rs.getInt(2));
					pack.setPackageName(rs.getString(3));
					pack.setAddOnId(rs.getString(4));
					pack.setTotalCost(rs.getFloat(5));
					pack.setDiscount(rs.getFloat(6));
					pack.setDiscountCost(rs.getFloat(7));
					packageList.add(pack);
				}
				return packageList;
			}
		});
	}
	
	public List<WashCosts> getWashCosts(String id) {
		logger.info("In getWashCosts");
		String sql = "SELECT ID, NAME, COST, TYPE FROM wash_costs where ID in ("+id+")";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<List<WashCosts>>() {

			@Override
			public List<WashCosts> doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {
			
				List<WashCosts> list = new ArrayList<>();
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					WashCosts washCost = new WashCosts();
					washCost.setId(rs.getInt(1));
					washCost.setName(rs.getString(2));
					washCost.setCost(rs.getInt(3));
					washCost.setType(rs.getString(4));
					list.add(washCost); 
				}
				return list;
			}
		});
	}
}


