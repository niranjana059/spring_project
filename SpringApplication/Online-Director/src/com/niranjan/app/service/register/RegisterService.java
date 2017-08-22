package com.niranjan.app.service.register;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.niranjan.app.dao.register.RegisterDAO;
import com.niranjan.app.dto.register.RegisterDTO;

@Service
public class RegisterService {
	
	public static final String ACTIVATION_URL_PREFIX="http://localhost:8080/Online-Director/activate_account.do?";

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private RegisterDAO registerDAO;

	public RegisterService(){
		System.out.println(this.getClass().getSimpleName()+" created....");
	}

	public int userRegisterService(RegisterDTO dto) throws MessagingException{
		System.out.println("userRegisterService method started.... ");
		int pKey=registerDAO.saveUser(dto);
		if(pKey!=0){
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(dto.getEmail());
			simpleMailMessage.setSubject("activation");
			String activation_url_postfix="emailId="+dto.getEmail();
			simpleMailMessage.setText("please activate by clicking below link \n \n "+ACTIVATION_URL_PREFIX+activation_url_postfix);
			mailSender.send(simpleMailMessage);
		}  
		System.out.println("userRegisterService method ended.... ");
		return pKey;
	}
}
