package com.revature.p0.services;

import com.revature.p0.daos.AccountDAO;
import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.exceptions.ResourcePersistenceException;
import com.revature.p0.models.Account;
import com.revature.p0.models.Customer;
import com.revature.p0.util.collections.List;

public class AccountService {
	
	private final AccountDAO accountDAO;
	private final CustomerService customerService;
	
	public AccountService(AccountDAO accountDAO, CustomerService customerService) {
		this.accountDAO = accountDAO;
		this.customerService = customerService;
	}
	
	// TODO: Monster Creation implementation
	public void createAccount(Account newAccount) {
		if(!isAccountValid(newAccount)) {
			throw new InvalidRequestException("Invalid account information");
		}
		
		newAccount.setOriginator(customerService.getSessionCustomer());
		Account createdAccount = accountDAO.create(newAccount);
		
		if(createdAccount == null) {
			throw new ResourcePersistenceException("The Account could not be saved");
		}
	}
	
	private boolean isAccountValid(Account newAccount) {
		
		if(newAccount == null) return false;
		if(newAccount.getAccountName() == null || newAccount.getAccountName().trim().equals("")|| Double.valueOf(newAccount.getAccountBalance()) < 0) return false;
		return newAccount.getAccountName() != null || !newAccount.getAccountName().trim().equals("");
	}
	
	public Account findMyAccount(String username){
		// tried to cast an Account to a List<Account> just convert the return type to Account
		return accountDAO.findByUsername(username); 
	}
	
	public List<Account> findAllAccount(){
		return accountDAO.findAll();
	}

//	public Account findByUsername(String username) {
//		// TODO Auto-generated method stub
//		return accountDAO.findByUsername(username);
//	}

}
