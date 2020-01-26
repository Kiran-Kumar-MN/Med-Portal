package com.xworkz.medi.service;

import com.xworkz.medi.dto.SigninDTO;
import com.xworkz.medi.entity.SignupEntity;

public interface SigninService {

	public SignupEntity signinValidate(SigninDTO signinDTO);
	
}
