package com.xworkz.medi.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dto.SigninDTO;
import com.xworkz.medi.entity.SignupEntity;

@Repository
public class SigninDAOImpli implements SigninDAO {

	private SessionFactory factory;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SigninDAOImpli.class);

	@Autowired
	public SigninDAOImpli(SessionFactory factory) {
		super();
		LOGGER.info("Session factory for signing created " + factory);
		this.factory = factory;
	}

	@Override
	public SignupEntity fetch(SigninDTO signinDTO) {
		Session session = null;
		try {
			LOGGER.info("Inside fetch method");

			LOGGER.info("Session created");
			session = factory.openSession();
			LOGGER.info("Opening session");
			session.beginTransaction();
			LOGGER.info("Begining transaction");
			String hql = "from SignupEntity where email='" + signinDTO.getEmail() + "' and password='"
					+ signinDTO.getPassword() + "'";
			LOGGER.info(hql);
			Query query = session.createQuery(hql);
			LOGGER.info("Creation of query is done");
			SignupEntity signupEntity = (SignupEntity) query.uniqueResult();
			LOGGER.info("Data from SigninDAO" + signupEntity);
			return signupEntity;

		} catch (Exception e) {
			System.err.println("Exception in fetching the data");
			e.printStackTrace();
		}
		return null;
	}

}
