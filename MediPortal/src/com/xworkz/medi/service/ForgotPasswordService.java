package com.xworkz.medi.service;

import com.xworkz.medi.dto.ForgotPasswordDTO;

public interface ForgotPasswordService {

	public String resetPasswordService(ForgotPasswordDTO forgotPasswordDTO);
	public boolean updatePasswordService(ForgotPasswordDTO forgotPasswordDTO);
	public boolean sendPasswordChangeMail(ForgotPasswordDTO forgotPasswordDTO);
	
}
