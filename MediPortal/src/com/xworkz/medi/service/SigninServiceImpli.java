package com.xworkz.medi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dao.SigninDAO;
import com.xworkz.medi.dto.SigninDTO;
import com.xworkz.medi.entity.SignupEntity;

@Service
public class SigninServiceImpli implements SigninService {

	@Autowired
	private SigninDAO signinDAO;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);

	@Override
	public SignupEntity signinValidate(SigninDTO signinDTO) {
		
		try {
			LOGGER.info("Validating SigninDTO");
			boolean valid = true;

			String email = signinDTO.getEmail();
			String password = signinDTO.getPassword();
			LOGGER.info(email);
			LOGGER.info(password);

			if (email != null && email.length() > 8 && email.length() < 50 && !email.isEmpty()) {
				LOGGER.info("Email is valid");
			} else {
				LOGGER.info("Email is invalid");
				valid = false;
			}
			if (password != null && password.length() > 8 && password.length() < 50 && !password.isEmpty()) {
				LOGGER.info("Password is valid");
			} else {
				LOGGER.info("Password is invalid");
				valid = false;
			}

			if (valid) {
				SignupEntity signupEntity = signinDAO.fetch(signinDTO);
				return signupEntity;
			}
		} catch (Exception e) {
			LOGGER.info("Exception in Signin Service");
			e.printStackTrace();
		}
		return null;
	}

}
