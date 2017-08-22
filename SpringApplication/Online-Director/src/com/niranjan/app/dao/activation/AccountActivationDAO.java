package com.niranjan.app.dao.activation;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountActivationDAO {

	@Autowired
	private SessionFactory factory;


	public int updateUserByEmailId(String emailId){
		System.out.println("updateUserByEmailId started");
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		String syntax="update RegisterDTO r set r.status=true where r.email=:eId"; 
		int count=0;
		try{
			Query query=session.createQuery(syntax);
			query.setParameter("eId", emailId);
			count=query.executeUpdate();
			tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		System.out.println("updateUserByEmailId started");
		return count;
	}
}
