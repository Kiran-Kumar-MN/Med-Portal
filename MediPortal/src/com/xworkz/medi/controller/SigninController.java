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

import com.xworkz.medi.dto.SigninDTO;
import com.xworkz.medi.entity.SignupEntity;
import com.xworkz.medi.service.SigninService;

@Controller
@RequestMapping("/")
public class SigninController {

	@Autowired
	private SigninService signinService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SigninController.class);

	public SigninController() {
		LOGGER.info("Default contructor invoked " + this.getClass().getSimpleName());
	}

//	@RequestMapping(value = "/Signin.med", method = RequestMethod.POST)
//	public ModelAndView signinValidate(SigninDTO signinDTO, ModelMap map) {
//		try {
//			boolean valid = this.signinService.signinValidate(signinDTO);
//			
//			if(valid) {
//				LOGGER.info("Singin is successful");
//				return new ModelAndView("SignedinHome","message","Signed in succesfully");	
//			}
//			else {
//				LOGGER.info("Sing-in is un-successful");
//				return new ModelAndView("Signin","message","Sign-in is un-succesfully");
//			}
//		} catch (Exception e) {
//			System.err.println("Error in signin controller");
//		}
//		LOGGER.info("Sing-in is not successful");
//		return new ModelAndView("Signin","message","Sign-in is not succesfully");
//		
//	}

	@RequestMapping(value = "/Signin.med", method = RequestMethod.POST)
	public ModelAndView signinController(SigninDTO signinDTO, HttpServletRequest request) throws Exception {
		SignupEntity dtoFromDB = signinService.signinValidate(signinDTO);
		LOGGER.info("Data from DB" + dtoFromDB);
		if (dtoFromDB != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("wall", dtoFromDB);
			LOGGER.info("Singin is successful");
			return new ModelAndView("SignedinHome", "message", "Signed in succesfully");
		} else {
			LOGGER.info("Sing-in is un-successful");
			return new ModelAndView("Signin", "message", "Sign-in is un-succesfully");
		}

	}


	@RequestMapping(value = "/Signout.med", method = RequestMethod.POST)
	public ModelAndView signOut(HttpServletRequest request) {
		LOGGER.info("Singout controller executed");
		HttpSession session = request.getSession(false);
		session.invalidate();
		LOGGER.info("Session after loggin out is " + session.toString());
		return new ModelAndView("Signin", "message", "You have successfully logged out");

	}
}
