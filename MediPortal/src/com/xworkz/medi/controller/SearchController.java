package com.xworkz.medi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.medi.entity.AppointmentEntity;
import com.xworkz.medi.entity.SignupEntity;
import com.xworkz.medi.service.SearchService;

@Controller
@RequestMapping("/")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SearchController.class);
	
	public SearchController() {
	LOGGER.info("Created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "search.med", method = RequestMethod.POST)
	private ModelAndView searchAppointment(HttpServletRequest request) {
		
		try {
			LOGGER.info("Invoked searchAppointment method");
			HttpSession session = request.getSession(false);
			if (session!=null) {
				String fdate = request.getParameter("fdate");
				String tdate = request.getParameter("tdate");
				SignupEntity singupEntity = (SignupEntity) session.getAttribute("wall");
				LOGGER.info(singupEntity.toString());
				List<AppointmentEntity> listDTOfromDB= searchService.searchService(fdate,tdate,singupEntity.getEmpID());
				//List<AppointmentEntity> listDTOfromDB= searchService.searchService(fdate,tdate,"Emp01");

				return new ModelAndView("Search","list",listDTOfromDB);
			}
		} catch (Exception e) {
			LOGGER.info("Exception in SearchController");
			e.printStackTrace();
		}
		return new ModelAndView("Search", "message", "Session has been closed please login");
		
	}
}
