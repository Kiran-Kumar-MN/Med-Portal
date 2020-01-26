package com.xworkz.medi.service;

import com.xworkz.medi.dto.SignupDTO;

public interface SignupService {

	public boolean signupValidate(SignupDTO signupDTO);
	public boolean sendMail(SignupDTO signupDTO);
}
