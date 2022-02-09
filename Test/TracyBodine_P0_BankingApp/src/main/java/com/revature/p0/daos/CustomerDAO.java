package com.revature.p0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.p0.models.Customer;
import com.revature.p0.util.collections.LinkedList;
import com.revature.p0.util.collections.List;
import com.revature.p0.util.datasource.ConnectionFactory;

public class CustomerDAO implements CrudDAO<Customer> {

	//Authentication
	public Customer findByUsernameAndPassword(String username, String password) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from customer where username = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}

	// TODO: Implement FindByEmail
	public Customer findByEmail(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customer where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	// TODO: Implement FindByUsername
	public Customer findByUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customer where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setLastName(rs.getString("lastname"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer create(Customer newCustomer) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			//converts a 128 bit number to a string value to use as the customer Id
			newCustomer.setCustomerId(UUID.randomUUID().toString());

			String sql = "insert into customer (customer_id, firstname, lastname, email, username, password) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newCustomer.getCustomerId());
			ps.setString(2, newCustomer.getFirstName());
			ps.setString(3, newCustomer.getLastName());
			ps.setString(4, newCustomer.getEmail());
			ps.setString(5, newCustomer.getUsername());
			ps.setString(6, newCustomer.getPassword());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newCustomer;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Customer> findAll() {

		List<Customer> customerList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customer";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString("customer_id"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setUsername(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));

				customerList.add(customer);
			}

			return customerList;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
