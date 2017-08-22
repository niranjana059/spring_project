package com.niranjan.app.controller.Activation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niranjan.app.service.activation.AccountActivationService;

@Controller
@RequestMapping("/")
public class AccountActivationController {

	@Autowired
	private AccountActivationService accountActivationService;

	@RequestMapping("activate_account.do")
	public ModelAndView activateAccountController(HttpServletRequest req){
		System.out.println("activateAccountController started");
		ModelAndView modelAndView=new ModelAndView();
		String emailId=req.getParameter("emailId");
		int count=accountActivationService.activateAccountService(emailId);
		if(count!=0){
			modelAndView.setViewName("activation_sucess.jsp");
		}else{
			modelAndView.setViewName("activation_failure.jsp");
		}
			System.out.println("activateAccountController ended");
		return modelAndView;
	}

}
