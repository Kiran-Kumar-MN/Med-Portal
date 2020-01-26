package com.xworkz.medi.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.entity.AppointmentEntity;

@Repository
public class RescheduleDAOImpli implements RescheduleDAO {

	@Autowired
	private SessionFactory factory;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RescheduleDAOImpli.class);
	
	@Autowired
	public RescheduleDAOImpli(SessionFactory factory) {
	LOGGER.info("Created Reschedule DAO Implimentation");
	this.factory=factory;
	}
	
	@Override
	public AppointmentEntity rescheduleSearchDAO(String id) {
		String hql = "from AppointmentEntity where id='"+id+"'";
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		AppointmentEntity appointmentEntity = (AppointmentEntity) query.uniqueResult();
		LOGGER.info("Data got using ID is "+appointmentEntity);
		return appointmentEntity;
	}

	@Override
	public boolean updateAppointment(AppointmentEntity appointmentEntity) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(appointmentEntity);
		LOGGER.info("Date is "+appointmentEntity.getDate());
		LOGGER.info("Time is "+appointmentEntity.getTime());
		LOGGER.info("Reason is "+appointmentEntity.getReason());
		LOGGER.info("ID is "+appointmentEntity.getId());
		
		String hql = "update AppointmentEntity set date=:date ,time=:time ,reason=:reason where id=:id";
	    Query query = session.createQuery(hql);
	    query.setParameter("date", appointmentEntity.getDate());
	    query.setParameter("time", appointmentEntity.getTime());
	    query.setParameter("reason", appointmentEntity.getReason());
	    query.setParameter("id", appointmentEntity.getId());
	    int i = query.executeUpdate();
	    session.getTransaction().commit();
	    LOGGER.info("Number of rows updated "+i);
	    if(i!=0) {
	    	return true;
	    }
		
		return false;
	}


}
