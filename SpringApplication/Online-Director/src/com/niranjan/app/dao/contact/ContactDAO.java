package com.niranjan.app.dao.contact;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niranjan.app.dto.contact.ContactDTO;
import com.niranjan.app.dto.register.RegisterDTO;

@Repository
public class ContactDAO {	

	@Autowired
	private SessionFactory factory;

	public ContactDAO() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	public int saveContact(ContactDTO contactDTO){
		System.out.println("saveContact started...");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		int pKey=0;
		try{
			pKey=(int) session.save(contactDTO);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println("saveContact ended...");
		return pKey;
	}

	public RegisterDTO fetchContactsByUserId(int id){
		System.out.println("fetchContactsByUserId started...");
		Session session=factory.openSession();
		RegisterDTO registerDTO=null;
		try{    		 
			registerDTO=session.get(RegisterDTO.class, id); 
			System.out.println("country name.."+registerDTO.getCountry());
			System.out.println(registerDTO.getContactDTO());
			/*for(ContactDTO contact:registerDTO.getContactDTO()){
    			System.out.println(contact.toString());
    		}*/

		}catch(HibernateException e){
			e.printStackTrace();

		}


		System.out.println("fetchContactsByUserId ended...");
		return registerDTO;
	}


	public ContactDTO fetchContactByNumber(int number){
		System.out.println("fetchContactByNumber started...");
		Session session=factory.openSession();
		String syntax="select c from ContactDTO c where c.number=:num";
		ContactDTO contactDTO=null;
		try{
			Query query=session.createQuery(syntax);
			query.setParameter("num", number);
			contactDTO=(ContactDTO) query.uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("fetchContactByNumber ended...");
		return contactDTO;
	}

	public ContactDTO fetchContactByPKey(int pKey){
		System.out.println("fetchContactByPKey started...");
		Session session=factory.openSession();
		ContactDTO contactDTO=null;
		try{
			contactDTO=session.get(ContactDTO.class, pKey);
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}

		System.out.println("fetchContactByPKey started...");
		return contactDTO;
	}

	public void updateContact(ContactDTO contactDTO){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(contactDTO);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
}
