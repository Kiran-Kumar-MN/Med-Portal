package com.xworkz.medi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.medi.dto.ForgotPasswordDTO;
import com.xworkz.medi.service.ForgotPasswordService;

@Controller
@RequestMapping("/")
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ForgotPasswordController.class);
	
	public ForgotPasswordController() {
	LOGGER.info("Forgot password difault contructor");
	}
	
	@RequestMapping("/forgotpassword.med")
	public ModelAndView forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked forgot password in controller");
		
		try {
			String entity = this.forgotPasswordService.resetPasswordService(forgotPasswordDTO);
			if(entity!=null) {
				LOGGER.info("New password is generated");
				return new ModelAndView("UpdatePassword","message","New password is generated please reset the password");
			}else {
					LOGGER.info("Invalid User");
					return new ModelAndView("ForgotPassword","message","User Not Exist");
				}
		} catch (Exception e) {
		LOGGER.info("Handle in resetPasswordController");
			e.printStackTrace();
		}
		
		return new ModelAndView("ForgotPassword","message","User Not Exist");
	}
	
	@RequestMapping("/updatepassword.med")
	public ModelAndView updatePasswordController(ForgotPasswordDTO forgotPasswordDTO) {
		LOGGER.info("Invoked Update password controller");
		
		try {
			boolean noOfRowsUpdated=this.forgotPasswordService.updatePasswordService(forgotPasswordDTO);
			if (noOfRowsUpdated) {
				LOGGER.info("Password updated");
				return new ModelAndView("Signin","message","Please login with new password");
			}else
			{
				LOGGER.info("Please enter correct password");
				return new ModelAndView("UpdatePassword","message","Please enter correct details");
			}
		} catch (Exception e) {
			LOGGER.info("Handle exceltion in updatePasswordController");
			e.printStackTrace();
		}
		
		return new ModelAndView("UpdatePassword","message","Please enter correct details");
	}
	
}