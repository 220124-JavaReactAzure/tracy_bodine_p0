package com.revature.p0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.p0.models.Account;
import com.revature.p0.util.collections.List;
import com.revature.p0.util.datasource.ConnectionFactory;

public class AccountDAO implements CrudDAO<Account> {
	
	// TODO: Implement search by customerrID
	public List<Account> findAccountByCustomerId(String id){
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
			ps.setString(4, newAccount.getAccountBalance());
			ps.setString(5, newAccount.getOriginator().getCustomerId());

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
		// TODO Auto-generated method stub
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

}
