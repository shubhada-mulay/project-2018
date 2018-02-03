package com.ocab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocab.dao.daoImpl.UserOperationsDAOImpl;
import com.ocab.model.User;
import com.ocab.utility.ClsValidations;


@SuppressWarnings("serial")
public class CheckCredential extends HttpServlet {

	UserOperationsDAOImpl usrOpImpl;
	
	public CheckCredential() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		usrOpImpl = this.getUsrOpDaoImpl(usrOpImpl);
		
		String userIdenInput = (ClsValidations.validateEmail(request.getParameter("email").trim())) 
					? request.getParameter("email").trim():"";
		
		String userPassword = request.getParameter("password").trim();
		
		if(usrOpImpl.isValidUser(userIdenInput, userPassword)) {
			User user = usrOpImpl.getUserDetail(userIdenInput);
			request.setAttribute("user",user);
		}
	}
	
	private UserOperationsDAOImpl getUsrOpDaoImpl(UserOperationsDAOImpl usrOpImpl) {
		this.usrOpImpl=usrOpImpl;
		return usrOpImpl;
	}

}
