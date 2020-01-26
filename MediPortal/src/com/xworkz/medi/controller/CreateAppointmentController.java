package com.xworkz.medi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.medi.dto.AppointmentDTO;
import com.xworkz.medi.entity.SignupEntity;
import com.xworkz.medi.service.CreateAppointmentService;

@Controller
@RequestMapping("/")
public class CreateAppointmentController {

	@Autowired
	private CreateAppointmentService createAppointmentService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);
	
	public CreateAppointmentController() {
	LOGGER.info("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "createAppointment.med", method = RequestMethod.POST)
	public ModelAndView appointmentController(AppointmentDTO appointmentDTO, HttpServletRequest request) throws Exception{
		LOGGER.info("Appointment Controller Started");
		
		HttpSession session = request.getSession(false);
		LOGGER.info("Session is "+session);
		if (session!=null) {
			LOGGER.info("Inside controller after session is not equal to null");
			SignupEntity dtoFromSession= (SignupEntity) session.getAttribute("wall");
			BeanUtils.copyProperties(dtoFromSession, appointmentDTO);
			LOGGER.info("DTO from session = "+dtoFromSession);
			LOGGER.info("Update appointment = "+appointmentDTO);
			appointmentDTO.setEmp_ID(dtoFromSession.getEmpID());
			appointmentDTO.setEmp_Email(dtoFromSession.getEmail());
			AppointmentDTO appointmentDTO2 = createAppointmentService.appointmentService(appointmentDTO);
			LOGGER.info("Data from DB = "+appointmentDTO2);
			LOGGER.info("Appointment Controller Ended");
			return new ModelAndView("SignedinHome", "message", "Appointment Created Successfully");
		}
		else {
		return new ModelAndView("Signin", "message", "Session has been closed please login");
		}
	}
}
