package com.niranjan.app.controller.register;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niranjan.app.dto.register.RegisterDTO;
import com.niranjan.app.service.register.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	private RegisterService registerService; 

	public RegisterController(){
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public ModelAndView userRegisterController(RegisterDTO dto){
		System.out.println("userRegisterController method started....");
		dto.setStatus(false);
		int pKey = 0;
		try {
			pKey = registerService.userRegisterService(dto);
		} catch (MessagingException e) {
			System.out.println("handled the messageing exception");
			e.printStackTrace();
		}
		ModelAndView modelAndView=new ModelAndView(); 
		if(pKey!=0){
		modelAndView.setViewName("sign_up_sucess.jsp");
		System.out.println("userRegisterController method ended....");
		}else{
			modelAndView.setViewName("sign_up_failure.jsp");
		}
		return modelAndView;
	}
}
