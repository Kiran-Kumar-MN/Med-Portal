package com.xworkz.medi.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.dto.ForgotPasswordDTO;
import com.xworkz.medi.entity.SignupEntity;

@Repository

public class ForgotPasswordImpli implements ForgotPasswordDAO{

	
	private SessionFactory factory;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ForgotPasswordImpli.class);
	
	@Autowired
	public ForgotPasswordImpli(SessionFactory factory) {
	LOGGER.info("Forgot password DAO contruction with session factory parameter invoked");
	this.factory=factory;
	}
	
	
	@Override
	public boolean forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		Session session = null;
		
		try {
			session = factory.openSession();
			session.beginTransaction();
			String email=forgotPasswordDTO.getEmail();
			String hqlQuery= "from SignupEntity where email=:em";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("em", email);
			Object entity=query.uniqueResult();
			LOGGER.info("Entity of forgot password is "+entity);
			if (entity!=null) {
				String hqlPass="update SignupEntity set password=:password where email=:em";
				Query query2=session.createQuery(hqlPass);
				query2.setParameter("em", email);
				query2.setParameter("password", forgotPasswordDTO.getPassword());
				Integer in = query2.executeUpdate();
				LOGGER.info("Updated row is "+in);
				LOGGER.info("Email is found");
				session.getTransaction().commit();
				return true;			
			}
			else {
				LOGGER.info("Please enter correct details");
			}
		} catch (Exception e) {
			LOGGER.info("Excpetion in handling forgot password DAO");
			e.printStackTrace();
		}
		finally {
			if(session !=null) {
				session.close();
			}
		}
		
		return false;
	}

	@Override
	public boolean updatePassword(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked update password");
		Session session = null;
		
		try {
			session= factory.openSession();
			session.beginTransaction();
			/*
			 * String email = forgotPasswordDTO.getEmail(); String password =
			 * forgotPasswordDTO.getPassword();
			 */
			/* LOGGER.info(password); */
			String hql = "from SignupEntity where email=:email and password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("email", forgotPasswordDTO.getEmail());
			query.setParameter("password", forgotPasswordDTO.getPassword());
			SignupEntity object = (SignupEntity) query.uniqueResult();
			LOGGER.info("Sugnup entity odject "+object);
			if(object!=null) {				
				String hqlnew= "update SignupEntity set password=:newpassword where email=:em";
				Query query2 = session.createQuery(hqlnew);
				query2.setParameter("em", forgotPasswordDTO.getEmail());
				query2.setParameter("newpassword", forgotPasswordDTO.getNewpassword());
				int i=query2.executeUpdate();
				LOGGER.info("New Updated row is "+i);
				session.getTransaction().commit();
				return true;
			}
		} catch (Exception e) {
			LOGGER.info("Exception in updating password in DAO");
			e.printStackTrace();
		}
		
		return false;
	}

	
}
