package com.revature.p0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.p0.models.Account;
import com.revature.p0.models.Customer;
import com.revature.p0.util.collections.LinkedList;
import com.revature.p0.util.collections.List;
import com.revature.p0.util.datasource.ConnectionFactory;

public class AccountDAO implements CrudDAO<Account> {
	
	// TODO: Implement search by customerrID
	public List<Account> findAccountByCustomerId(String id){
		return null;
	}
	
	// TODO: Implement FindByUsername
	public Account findByUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getString("accountid"));
				account.setAccountName(rs.getString("accountname"));
				account.setAccountType(rs.getString("accounttype"));
				account.setAccountBalance(rs.getDouble("accountbalance"));
//				account.setOriginator(rs.getOriginator("originator"));
				
				return account;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findByUsernameAndAccountname(String username, String accountname) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from account where username = ? and accountname = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, accountname);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getString("accountid"));
				account.setAccountName(rs.getString("accountname"));
				account.setAccountType(rs.getString("accounttype"));
				account.setAccountBalance(rs.getDouble("accountbalance"));
//				account.setOriginator(rs.getCustomer("originator"));
				
				return account;
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account create(Account newAccount) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			//converts a 128 bit number to a string value to use as the account Id
			newAccount.setAccountId(UUID.randomUUID().toString());

			String sql = "insert into account (accountId, accountName, accountType, accountBalance, originator) values (?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newAccount.getAccountId());
			ps.setString(2, newAccount.getAccountName());
			ps.setString(3, newAccount.getAccountType());
			ps.setDouble(4, newAccount.getAccountBalance());
			ps.setString(5, newAccount.getOriginator().getUsername());
						
			//ps.setString(5, newAccount.getOriginator().getCustomerId());
			//ps.setString(6, newAccount.getCustomerId());
			
			
			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newAccount;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public List<Account> findAll() {

		List<Account> accountList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Account account = new Account();
				account.setAccountId(resultSet.getString("accountid"));
				account.setAccountName(resultSet.getString("accountname"));
				account.setAccountType(resultSet.getString("accounttype"));
				account.setAccountBalance(resultSet.getDouble("accountbalance"));
//				account.setOriginator(resultSet.getOriginator("originator"));
				
				accountList.add(account);
			}

			return accountList;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account updatedAccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findByUsername2(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
