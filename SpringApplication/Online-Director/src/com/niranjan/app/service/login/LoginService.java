package com.niranjan.app.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niranjan.app.dao.login.LoginDAO;
import com.niranjan.app.dto.login.LoginDTO;
import com.niranjan.app.dto.register.RegisterDTO;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	public LoginService(){
		System.out.println(this.getClass().getSimpleName()+" created..");
	}

	public RegisterDTO userLoginService(LoginDTO dto){
		System.out.println("userLoginService started...");	
		System.out.println("userLoginService ended...");
		return loginDAO.fetchByUserName(dto); 
	}

}
