package com.niranjan.app.dao.login;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niranjan.app.dto.login.LoginDTO;
import com.niranjan.app.dto.register.RegisterDTO;

@Repository
public class LoginDAO {
	@Autowired
	private SessionFactory factory;
	public LoginDAO(){
		System.out.println(this.getClass().getSimpleName()+" created...");
	}

	public RegisterDTO fetchByUserName(LoginDTO dto){
		System.out.println("fetchByUserName started...");
		Session session=factory.openSession();
		RegisterDTO registerDTO=null;
		String syntax="select t from RegisterDTO t where t.userName=:un and t.password=:p";
		try{
			Query query=session.createQuery(syntax);
			query.setParameter("un", dto.getUserName());
			query.setParameter("p",dto.getPassword());
			registerDTO=(RegisterDTO) query.uniqueResult();		

		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}	
		System.out.println("fetchByUserName end...");
		return registerDTO;
	}
}
