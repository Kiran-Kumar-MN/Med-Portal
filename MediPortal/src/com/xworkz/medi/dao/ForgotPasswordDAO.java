package com.xworkz.medi.dao;

import com.xworkz.medi.dto.ForgotPasswordDTO;

public interface ForgotPasswordDAO {

	public boolean forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
	public boolean updatePassword(ForgotPasswordDTO forgotPasswordDTO);
}
