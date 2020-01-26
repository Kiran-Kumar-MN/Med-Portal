package com.xworkz.medi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.medi.dto.SignupDTO;
import com.xworkz.medi.service.SignupService;

@Controller
@RequestMapping("/")
public class SignupController {

	@Autowired
	private SignupService signupService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SignupController.class);

	public SignupController() {
		LOGGER.info("Signup Controller Created");
	}

	@RequestMapping (value = "/signup.med", method = RequestMethod.POST)
	public ModelAndView signupValidate(SignupDTO signupDTO, ModelMap map) {
		try {
			LOGGER.info("ID is "+signupDTO.getEmpID());
			LOGGER.info("Calling service method");
			boolean valid = this.signupService.signupValidate(signupDTO);
			if (valid) {
				LOGGER.info("Signing up is done");
				return new ModelAndView("Signin","message","Successfully registered please Sign-in");
			}
			else {
				LOGGER.info("Sign-up failed");
				return new ModelAndView("Signup","message","Registration failed please enter valid details");
			}
		} catch (Exception e) {
			System.err.println("Exception in Controller");
			e.printStackTrace();
		}

		LOGGER.info("Signup up is Failed");
		return new ModelAndView("Signup","message","Registration failed please enter valid details");

	}

}
