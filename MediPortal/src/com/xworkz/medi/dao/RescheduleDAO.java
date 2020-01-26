package com.xworkz.medi.dao;

import com.xworkz.medi.entity.AppointmentEntity;

public interface RescheduleDAO {

	public AppointmentEntity rescheduleSearchDAO(String id);
	
	public boolean updateAppointment(AppointmentEntity appointmentEntity);
}
