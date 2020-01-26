package com.xworkz.medi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.xworkz.medi.controller.CreateAppointmentController;
import com.xworkz.medi.dao.ForgotPasswordDAO;
import com.xworkz.medi.dto.ForgotPasswordDTO;
import com.xworkz.medi.util.RandomPasswordGenerator;

@Service
public class ForgotPasswordServiceImpli implements ForgotPasswordService {

	@Autowired
	private MailSender mailsender;
	@Autowired
	private ForgotPasswordDAO forgotPasswordDAO;
	@Autowired
	private RandomPasswordGenerator randomPasswordGenerator;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(CreateAppointmentController.class);

	public ForgotPasswordServiceImpli() {
		LOGGER.info("Created " + this.getClass().getSimpleName());
	}

	@Override
	public String resetPasswordService(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked resetPassswordService method");
		String password = randomPasswordGenerator.generateRandomPassword();
		forgotPasswordDTO.setPassword(password);
		String email = forgotPasswordDTO.getEmail();

		try {
			boolean entity = forgotPasswordDAO.forgotPassword(forgotPasswordDTO);
			if (entity) {
				LOGGER.info("Entity is "+entity);
				this.sendPasswordChangeMail(forgotPasswordDTO);
				return email;
			}
		} catch (Exception e) {
			LOGGER.info("Handle in resetPassword services");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePasswordService(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked updatePasswordService");
		String password = forgotPasswordDTO.getPassword();
		String newpassword = forgotPasswordDTO.getNewpassword();
		String confirmpassword = forgotPasswordDTO.getConfirmPassword();
		LOGGER.info("Current password " + password);
		LOGGER.info("New password " + newpassword);
		LOGGER.info("New Confirm password " + confirmpassword);

		boolean validPass = true;

		try {
			LOGGER.info("Entered Try catch of update password in Service implimentation");
			LOGGER.info("ValidPass value "+validPass);
			if (validPass == true) {
				if (newpassword.length()>8 && newpassword.length()<16 && confirmpassword.length()>8
						&& confirmpassword.length()<16 && newpassword.equals(confirmpassword)) {
					LOGGER.info("Password entered is valid and matching");
				} else {
					return false;
				}
			}
			if (validPass) {
				validPass = forgotPasswordDAO.updatePassword(forgotPasswordDTO);
				return validPass;
			}
		} catch (Exception e) {
			LOGGER.info("Handle in update password service implimentation");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean sendPasswordChangeMail(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked Send-mail");
		LOGGER.info(forgotPasswordDTO.getEmail());

		try {
			LOGGER.info("Mail preparing to send");
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(forgotPasswordDTO.getEmail());
			mailMessage.setSubject("Resetting Password");
			mailMessage.setText(
					"Mr/Mrs " + forgotPasswordDTO.getEmail() + " reset password is " + forgotPasswordDTO.getPassword());
			mailsender.send(mailMessage);
			LOGGER.info("Change password Mail sent to " + forgotPasswordDTO.getEmail() + "reset password"
					+ forgotPasswordDTO.getPassword());
			return true;
		} catch (Exception e) {
			LOGGER.info("Handle in sendmail");
			e.printStackTrace();
		}
		return false;
	}
}
