package com.xworkz.medi.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registration_details")
public class ForgotPasswordDTO {

	private String email;
	private String password;
	private String newpassword;
	private String confirmPassword;

	public ForgotPasswordDTO() {
		System.out.println("Forgot password DTO");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ForgotPasswordDTO [email=" + email + ", password=" + password + ", newpassword=" + newpassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}
}
