package com.niranjan.app.service.activation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niranjan.app.dao.activation.AccountActivationDAO;

@Service
public class AccountActivationService {

	@Autowired
	private AccountActivationDAO accountActivationDAO;

	public int activateAccountService(String emailId){
		System.out.println("activateAccountService started");
		int count=accountActivationDAO.updateUserByEmailId(emailId);
		System.out.println("activateAccountService ended");
		return count;		
	}
}
