package com.xworkz.medi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dao.CreateAppointmentDAO;
import com.xworkz.medi.dto.AppointmentDTO;
import com.xworkz.medi.entity.AppointmentEntity;

@Service
public class CreateAppointmentServiceImpli implements CreateAppointmentService {

	@Autowired
	private CreateAppointmentDAO appointmentDAO;
	
	@Autowired
	private MailSender mailSender;

	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);
	
	public CreateAppointmentServiceImpli() {
	LOGGER.info("Appointment generation service implimention is invoked");
	}
	
	@Override
	public AppointmentDTO appointmentService(AppointmentDTO appointmentDTO){

		AppointmentEntity appointmentEntity = new AppointmentEntity();
		BeanUtils.copyProperties(appointmentDTO, appointmentEntity);
		String dtoFromDB = appointmentDAO.appointmentGeneration(appointmentEntity);
		LOGGER.info("Data from DB = "+dtoFromDB);
		this.sendMail(appointmentDTO);
		return appointmentDTO;
	}

	@Override
	public void sendMail(AppointmentDTO appointmentDTO) {
		LOGGER.info("Sending mail for scheduling appointment");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(appointmentDTO.getEmp_Email());
		mailMessage.setSubject("Appoitment from Med-Portal");
		mailMessage.setText("Dear Customer with employee ID"+appointmentDTO.getEmp_ID()+" your appointment has been succesfully scheduled to "+appointmentDTO.getDate()+" at "+appointmentDTO.getTime()+" for cause of "+appointmentDTO.getReason());
		mailSender.send(mailMessage);
	}

}
