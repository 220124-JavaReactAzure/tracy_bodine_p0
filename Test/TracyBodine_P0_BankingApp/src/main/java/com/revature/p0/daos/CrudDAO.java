package com.revature.p0.daos;

import com.revature.p0.models.Account;
import com.revature.p0.models.Customer;
import com.revature.p0.util.collections.List;

public interface CrudDAO<T> {

	// CRUD: Create, Read, Update, Delete

	// Create
	T create(T newObj);
	
	// Read
	List<T> findAll();
	T findById(String id);
	Account findByUsername(String username);
	Customer findByUsername2(String username);
	
	// Update
	boolean update(T updatedObj);
	
	// Delete
	boolean delete(String id);
}
