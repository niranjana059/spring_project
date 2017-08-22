package com.niranjan.app.service.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niranjan.app.dao.contact.ContactDAO;
import com.niranjan.app.dto.contact.ContactDTO;
import com.niranjan.app.dto.register.RegisterDTO;

@Service
public class ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public ContactService() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}
	public int addContactService(ContactDTO contactDTO){
		System.out.println("addContactService started..");
		System.out.println("addContactService ended..");
		return contactDAO.saveContact(contactDTO);		
	}
	
	public RegisterDTO getUserContactsService(int id){
		System.out.println("getUserContactsService started...");
		RegisterDTO registerDTO=contactDAO.fetchContactsByUserId(id);
		System.out.println("getUserContactsService ended...");
		return registerDTO;
	}
	
	public ContactDTO getContactByNumber(int number){
		System.out.println("getContactByNumber started...");
		ContactDTO contactDTO=contactDAO.fetchContactByNumber(number);
		System.out.println("getContactByNumber ended...");
		return contactDTO;
	}
	
	public ContactDTO getContactByPKey(int pKey){
		System.out.println("getContactByPKey started...");
		ContactDTO contactDTO=contactDAO.fetchContactByPKey(pKey);
		System.out.println("getContactByPKey started...");
		return contactDTO;
	}
	
	public void updateContact(ContactDTO contactDTO){
		System.out.println("updateContact started...");
		contactDAO.updateContact(contactDTO);
		System.out.println("updateContact ended...");
	}
}
