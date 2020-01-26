package com.xworkz.medi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.medi.dto.AppointmentDTO;
import com.xworkz.medi.entity.AppointmentEntity;
import com.xworkz.medi.entity.SignupEntity;
import com.xworkz.medi.service.RescheduleService;

@Controller
@RequestMapping("/")
public class RescheduleController {

	@Autowired
	private RescheduleService rescheduleService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(RescheduleController.class);
	
	public RescheduleController() {
	LOGGER.info("Created Reschedule Controller");
	}
	
	@RequestMapping(value = "/reschedule.med", method = RequestMethod.GET)
	public ModelAndView rescheduleSearchController(HttpServletRequest httpServletRequest) {
		
		HttpSession session = httpServletRequest.getSession(false);
		LOGGER.info("Session is "+session);
		if(session!=null) {
		AppointmentEntity appointmentEntity;
		try {
			String id= httpServletRequest.getParameter("appId");
			LOGGER.info("ID is "+id);
			appointmentEntity = rescheduleService.rescheduleSearchService(id);
		return new ModelAndView("RescheduleAppointment","appointmentEntity",appointmentEntity);
		
		} catch (Exception e) {
			LOGGER.info("Exception in Reschedule Search Controller");
			e.printStackTrace();
		}
		return new ModelAndView("SignedinHome","message","Edit failed please try again");
		}
		return new ModelAndView("Signin","message","Session Expired please Signin again");
	}
	
	@RequestMapping(value = "/reschedule.med", method = RequestMethod.POST)
	public ModelAndView rescheduleController(AppointmentDTO  appointmentDTO,HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		LOGGER.info("Session is "+session);
		if (session!=null) {
		SignupEntity dataFromSession = (SignupEntity) session.getAttribute("wall");	
		appointmentDTO.setEmp_ID(dataFromSession.getEmpID());
		appointmentDTO.setEmp_Email(dataFromSession.getEmail());
		boolean updated = rescheduleService.updateApointment(appointmentDTO);
		if (updated) {
			return new ModelAndView("SignedinHome","message","Appointment has been rescheduled");
		}
		
		return new ModelAndView("SignedinHome","message","Appointment has been rescheduling failed");
		}
	return new ModelAndView("Signin","message","Session Expired please Signin again");
	}
	
	
}
