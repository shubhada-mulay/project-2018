package com.ocab.dao;

import java.util.List;

import com.ocab.model.User;

public interface UserOperationsDAO {

	
	public boolean isValidUser(String userIdenInput,String userPassword);
	public User getUserDetail(String userIdenInput);
	public List<User> getAllUsers();
	
}
