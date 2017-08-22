package com.niranjan.app.controller.contact;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niranjan.app.dto.contact.ContactDTO;
import com.niranjan.app.dto.register.RegisterDTO;
import com.niranjan.app.service.contact.ContactService;

@Controller
@RequestMapping("/")
public class ContactController {

	@Autowired
	private ContactService contactService;

	public ContactController() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}
	@RequestMapping(value="addContact.do",method=RequestMethod.GET)
	public ModelAndView addContactController(ContactDTO contactDTO, HttpServletRequest httpServletRequest){
		System.out.println("addContactController started...");
		HttpSession httpSession=httpServletRequest.getSession(false);
		RegisterDTO registerDTO=(RegisterDTO)httpSession.getAttribute("registerDTO");
		contactDTO.setRegisterDTO(registerDTO);
		Set<ContactDTO> contacts = new HashSet<ContactDTO>();
		contacts.add(contactDTO);
		//registerDTO.setContactDTO(contacts);
		int pKey=contactService.addContactService(contactDTO);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("contact_add_status.jsp");
		if(pKey!=0){
			modelAndView.addObject("addContactStatus",true);			
		}else{
			modelAndView.addObject("addContactStatus",false);
		}
		System.out.println("addContactController ended...");
		return modelAndView;
	}

	@RequestMapping(value="show_contacts.do")
	public ModelAndView getUserAddedContacts(HttpServletRequest httpServletRequest){
		System.out.println("getUserAddedContacts started...");
		HttpSession httpSession=httpServletRequest.getSession(false);	
		RegisterDTO registerDTO=(RegisterDTO)httpSession.getAttribute("registerDTO");
		RegisterDTO registerDTO2=contactService.getUserContactsService(registerDTO.getId());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("show_contacts.jsp");
		System.out.println(registerDTO2.getContactDTO());		
		modelAndView.addObject("contacts", registerDTO2.getContactDTO());
		System.out.println("getUserAddedContacts ended...");
		return modelAndView;
	}
	
	
	@RequestMapping(value="search.do")
	public ModelAndView searchContact(HttpServletRequest req){
		System.out.println("searchContact started...");
		ModelAndView modelAndView=new ModelAndView();
		int number=Integer.parseInt(req.getParameter("number"));
		ContactDTO contactDTO=contactService.getContactByNumber(number);
		modelAndView.setViewName("contact_information.jsp");
		modelAndView.addObject("contact",contactDTO);
		System.out.println("searchContact ended...");
		return modelAndView;
	}
	
	@RequestMapping(value="edit_contact.do")
	public ModelAndView fetchContactByPKey(HttpServletRequest httpServletRequest){
		System.out.println("fetchContactByPKey started...");
		ModelAndView modelAndView=new ModelAndView();
		int pKey=Integer.parseInt(httpServletRequest.getParameter("pKey"));		
		ContactDTO contactDTO=contactService.getContactByPKey(pKey);
		modelAndView.setViewName("edit_contact.jsp");
		modelAndView.addObject("contact", contactDTO);
		System.out.println("fetchContactByPKey ended...");
		return modelAndView;		
	}
	
	@RequestMapping(value="update_contact.do")
	public ModelAndView updateContactController(ContactDTO contactDTO,HttpServletRequest httpServletRequest){
		System.out.println("updateContactController started...");
		ModelAndView modelAndView=new ModelAndView();
		HttpSession httpSession=httpServletRequest.getSession(false);
		RegisterDTO registerDTO=(RegisterDTO)httpSession.getAttribute("registerDTO");
		contactDTO.setRegisterDTO(registerDTO);
		contactService.updateContact(contactDTO);
		modelAndView.setViewName("update_contact_status.jsp");
		System.out.println("updateContactController ended...");
		return modelAndView;
	}	
}
