package com.xworkz.medi.service;

import com.xworkz.medi.dto.AppointmentDTO;

public interface CreateAppointmentService {

	public AppointmentDTO appointmentService(AppointmentDTO appointmentDTO);
	
	public void sendMail(AppointmentDTO appointmentDTO);
}
