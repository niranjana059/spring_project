package com.niranjan.app.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niranjan.app.dto.login.LoginDTO;
import com.niranjan.app.dto.register.RegisterDTO;
import com.niranjan.app.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService service;

	public LoginController(){
		System.out.println(this.getClass().getSimpleName()+" created..");
	}


	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public ModelAndView userLogin(LoginDTO dto, HttpServletRequest req){
		System.out.println("userLogin started..");
		System.out.println("dto values::"+dto);
		ModelAndView modelAndView=new ModelAndView(); 
		RegisterDTO registerDTO=service.userLoginService(dto);
		System.out.println(registerDTO);
		if(registerDTO!=null) {
			//got a record from db
			if(registerDTO.isStatus()!=false){
				HttpSession httpSession=req.getSession(true);
				httpSession.setAttribute("registerDTO", registerDTO);
				modelAndView.setViewName("landing_page.jsp");
				modelAndView.addObject("userName", dto.getUserName());
			}else{
				modelAndView.setViewName("login.jsp");
				modelAndView.addObject("login_error", "Please activate your account by clicking on the link provided in your gmail account");
			}
		}else{
			// no such record
			modelAndView.setViewName("login.jsp");
			modelAndView.addObject("login_error", "user does not exist");
		}
		System.out.println("userLogin ended..");
		return modelAndView;
	}
}
