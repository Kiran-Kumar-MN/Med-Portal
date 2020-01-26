package com.xworkz.medi.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.entity.SignupEntity;
@Repository
public class SignupDAOImpli implements SignupDAO {

	private SessionFactory factory;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SignupDAOImpli.class);

	@Autowired
	public SignupDAOImpli(SessionFactory factory) {
		super();
		LOGGER.info("Session factory created " + factory);
		this.factory = factory;
	}

	@Override
	public boolean save(SignupEntity signupEntity) {
		LOGGER.info("Started " + signupEntity);
		Session session = null;

		try {
			session = factory.openSession();
			String hql = "from EmployeeDTO where empID='"+signupEntity.getEmpID()+"' and emp_email='"+signupEntity.getEmail()+"'";
			LOGGER.info("EmployeeDTO"+signupEntity.getEmpID());
			Query query = session.createQuery(hql);
			Object result = query.uniqueResult();
			LOGGER.info("Query result is "+result);
			
			if(result!=null) {
				LOGGER.info("Checking User is already exist or not");
				String hql2="from SignupEntity where empID='"+signupEntity.getEmpID()+"' and email='"+signupEntity.getEmail()+"'";
				LOGGER.info("SignupEntity"+signupEntity.getEmpID());
				Query query2 = session.createQuery(hql2);
				Object result2 = query2.uniqueResult();
				LOGGER.info("Query2 result is "+result2);
				LOGGER.info("After result 2");
				if(result2==null) {
					LOGGER.info("main execution");
				session.beginTransaction();
				session.save(signupEntity);
				session.getTransaction().commit();
				}
				else {
					LOGGER.info("User already exist please signin");
					return false;
				}
			}
				else {
					return false;
				}
		} catch (Exception e) {
			LOGGER.warn("Exception in saving registraion deatials");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		finally {
			LOGGER.info("Closing Costly resources");
			session.close();
		}
		return false;

	}
}
