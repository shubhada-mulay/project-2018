package com.ocab.dao.daoImpl;

import java.util.List;

import org.hibernate.Session;


import com.ocab.dao.UserOperationsDAO;
import com.ocab.model.User;
import com.ocab.utility.ClsHibernateUtil;

public class UserOperationsDAOImpl implements UserOperationsDAO {

	public boolean isValidUser(String userIdenInput, String userPassword) {
		boolean isUserAuthenticated = false;
		try(Session objSes=ClsHibernateUtil.getSessionFactory().openSession()){

			StorePr
			
		} catch (Exception e) {
			
		}
		return isUserAuthenticated;
	}

	public User getUserDetail(String userIdenInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
