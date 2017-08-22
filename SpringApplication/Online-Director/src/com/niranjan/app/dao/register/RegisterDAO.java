package com.niranjan.app.dao.register;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niranjan.app.dto.register.RegisterDTO;

@Repository
public class RegisterDAO {

	@Autowired
	private SessionFactory factory;

	public RegisterDAO(){
		System.out.println(this.getClass().getSimpleName()+"  created...");
	}

	public int saveUser(RegisterDTO dto){
		System.out.println("saveUser method started..");
	    int pKey=0;
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			pKey=(int) session.save(dto);
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println("saveUser method ended..");
		return pKey;
	}
}
