package com.xworkz.medi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dao.SearchDAO;
import com.xworkz.medi.entity.AppointmentEntity;
import com.xworkz.medi.entity.SignupEntity;

@Service
public class SearchServiceImpi implements SearchService {

	@Autowired
	private SearchDAO searchDAO;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);
	
	public SearchServiceImpi() {
	LOGGER.info("Created Search service = "+this.getClass().getSimpleName());
	}
	
	@Override
	public List<AppointmentEntity> searchService(String fdate, String tdate, String empID) {
		try {
			LOGGER.info("Invoked search Service impimentation");
			List<AppointmentEntity> list=  searchDAO.searchDAO(fdate,tdate,empID);
			for (AppointmentEntity appointmentEntity : list) {
				LOGGER.info("List in appointmentEntity is "+appointmentEntity);
			}
			return list;
		} catch (Exception e) {
			LOGGER.info("Exception in search Service implimentation");
			e.printStackTrace();
		}
		return null;
		
	}

}
