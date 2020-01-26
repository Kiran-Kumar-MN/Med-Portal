package com.xworkz.medi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.medi.entity.AppointmentEntity;

@Repository
public class SearchDAOImpli implements SearchDAO {

	@Autowired
	private SessionFactory factory;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SearchDAOImpli.class);
	
	@Autowired
	public SearchDAOImpli(SessionFactory factory) {
		super();
	LOGGER.info("Session factory invoked in Search");
	this.factory= factory;
	}
	
	@Override
	public List<AppointmentEntity> searchDAO(String fdate, String tdate, String empID) {
		try {
			LOGGER.info("Invoked Search DAO");
			LOGGER.info("From date"+fdate);
			LOGGER.info("To date"+tdate);
			LOGGER.info("Employee ID is "+empID);
			String hql= "from AppointmentEntity where date between '"+fdate+"' and '"+tdate+"' and emp_ID='"+empID+"'";
			Session session = factory.openSession();
			//Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
//			query.setParameter("fdate", fdate);
//			query.setParameter("tdate", tdate);
			LOGGER.info("Query executed for = "+fdate+" to "+tdate);
			List<AppointmentEntity> list = query.list();
			return list;
		} catch (Exception e) {
			LOGGER.info("Exception in search DAO");
			e.printStackTrace();
		}
		return null;
	}

}
