package com.xworkz.medi.dao;

import com.xworkz.medi.dto.SigninDTO;
import com.xworkz.medi.entity.SignupEntity;

public interface SigninDAO {

	public SignupEntity fetch(SigninDTO signinDTO);
}
