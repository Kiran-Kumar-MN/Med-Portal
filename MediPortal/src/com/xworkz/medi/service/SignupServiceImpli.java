package com.xworkz.medi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dao.SignupDAO;
import com.xworkz.medi.dto.SignupDTO;
import com.xworkz.medi.entity.SignupEntity;

@Service
public class SignupServiceImpli implements SignupService {

	@Autowired
	private SignupDAO signupDAO;

	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);

	public SignupServiceImpli() {
		LOGGER.info("Signup service implimentation created");
	}

	@Override
	public boolean signupValidate(SignupDTO signupDTO) {
		try {

			LOGGER.info("Validating the DTO");
			boolean valid = true;
			if (signupDTO != null) {
				String email = signupDTO.getEmail();
				String password = signupDTO.getPassword();
				String cofirmpassword = signupDTO.getConfirmpassword();
				if (email != null && email.length() > 8 && email.length() < 50 && !email.isEmpty()) {
					LOGGER.info("Email is valid");
				} else {
					LOGGER.info("Email is invalid");
					valid = false;
				}
				if (password != null && password.length() > 8 && password.length() < 50 && !password.isEmpty()) {
					LOGGER.info("password is valid");
				} else {
					LOGGER.info("password is invalid");
					valid = false;
				}
				if (cofirmpassword != null && cofirmpassword.length() > 8 && cofirmpassword.length() < 50
						&& !cofirmpassword.isEmpty()) {
					LOGGER.info("cofirmpassword is valid");
				} else {
					LOGGER.info("cofirmpassword is invalid");
					valid = false;
				}
				if (password.equals(cofirmpassword)) {
					LOGGER.info("Password is matching");
				} else {
					LOGGER.info("Password is not matching");
					valid = false;
				}

				if (valid) {
					LOGGER.info("Service implimentation method");
					SignupEntity signupentity = new SignupEntity();
					BeanUtils.copyProperties(signupDTO, signupentity);
					this.signupDAO.save(signupentity);
					if(valid) {
						this.sendMail(signupDTO);
					}
				}
				return valid;
			}

		} catch (Exception e) {
			System.err.println("Exception in Service implimentation");
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean sendMail(SignupDTO signupDTO) {
		LOGGER.info("Invoked Sendmail");
		LOGGER.info("SignupDTO is "+signupDTO);
		try {
			LOGGER.info("Prepare to Send");
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(signupDTO.getEmail());
			mailMessage.setSubject("Registration susccesfull");
			mailMessage.setText("Mr/Mrs " + signupDTO.getEmail()
					+ " you have successfully registered and your employee id is " + signupDTO.getEmpID());
			mailSender.send(mailMessage);
			LOGGER.info("Mail is sent to " + signupDTO.getEmail());
			return true;
		} catch (Exception e) {
			LOGGER.info("Exception in sending mail");
		}
		return false;
	}
}
