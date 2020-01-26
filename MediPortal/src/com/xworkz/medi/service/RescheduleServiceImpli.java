package com.xworkz.medi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.medi.dao.RescheduleDAO;
import com.xworkz.medi.dto.AppointmentDTO;
import com.xworkz.medi.entity.AppointmentEntity;

@Service
public class RescheduleServiceImpli implements RescheduleService {

	@Autowired
	private RescheduleDAO rescheduleDAO;
	
//	@Autowired
//	private MailSender mailSender;
	
	static final Logger LOGGER = LoggerFactory.getLogger(RescheduleServiceImpli.class);
	
	public RescheduleServiceImpli() {
	LOGGER.info("Created Reschedule Service implimentation");
	}
	
	@Override
	public AppointmentEntity rescheduleSearchService(String id) {
		AppointmentEntity appointmentEntity = rescheduleDAO.rescheduleSearchDAO(id);
		return appointmentEntity;
	}

	@Override
	public boolean updateApointment(AppointmentDTO appointmentDTO) {
		
		AppointmentEntity appointmentEntity = new AppointmentEntity();
		BeanUtils.copyProperties(appointmentDTO, appointmentEntity);
		boolean updated = rescheduleDAO.updateAppointment(appointmentEntity);
		//this.sendMail(appointmentDTO);
		return updated;
	}

//	@Override
//	public void sendMail(AppointmentDTO appointmentDTO) {
//		LOGGER.info("Sending mail for rescheduling");
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(appointmentDTO.getEmp_Email());
//		mailMessage.setSubject("Rescheduling of appointment");
//		mailMessage.setText("Dear Customer with employee ID"+appointmentDTO.getEmp_ID()+" your appointment has been succesfully rescheduled to "+appointmentDTO.getDate()+" at "+appointmentDTO.getTime()+" for cause of "+appointmentDTO.getReason());
//		mailSender.send(mailMessage);
//		
//	}

}
