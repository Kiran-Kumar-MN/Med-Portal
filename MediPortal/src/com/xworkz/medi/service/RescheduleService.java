package com.xworkz.medi.service;

import com.xworkz.medi.dto.AppointmentDTO;
import com.xworkz.medi.entity.AppointmentEntity;

public interface RescheduleService {

	public AppointmentEntity rescheduleSearchService(String id);
	
	public boolean updateApointment(AppointmentDTO appointmentDTO);
//	public void sendMail(AppointmentDTO appointmentDTO);
}
