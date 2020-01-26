package com.xworkz.medi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.entity.AppointmentEntity;

@Repository
public class CreateAppointmentImpli implements CreateAppointmentDAO {

	private SessionFactory factory;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentImpli.class);
	
	@Autowired
	public CreateAppointmentImpli(SessionFactory factory) {
	LOGGER.info("Created Session factory");
	this.factory = factory;
	}
	
	@Override
	public String appointmentGeneration(AppointmentEntity appointmentEntity) {
		Session session = null;
		
		try {
			session=factory.openSession();
			session.beginTransaction();
			LOGGER.info("After begining Transaction");
			session.save(appointmentEntity);
			session.getTransaction().commit();
//			String hql= "update AppointmentEntity set date=:date , time=:time , reason=:reason where emp_ID=:emp_id";
//			Query query = session.createQuery(hql);
//			
//			query.setParameter("date",appointmentEntity.getDate());
//			query.setParameter("time", appointmentEntity.getTime());
//			query.setParameter("reason", appointmentEntity.getReason());
//			query.setParameter("emp_id", appointmentEntity.getEmp_ID());
//			
//			int i = query.executeUpdate();
//			LOGGER.info("No of affected rows "+i);
//			session.getTransaction().commit();
			return "LOGGER.info(\"Successfull return appointment DAO\");";
		} catch (Exception e) {
			LOGGER.info("Exception in Appoint creation DAO");
			e.printStackTrace();
		}
		return "LOGGER.info(\"Unsuccessfull return appointment DAO\");";
	}

}
