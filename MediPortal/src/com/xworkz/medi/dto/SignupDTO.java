package com.xworkz.medi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "employee_table")
public class SignupDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1791791755913453012L;
	
	private int id;

	private String empID;
	

	private String email;
	
	private String password;
	
	private String confirmpassword;
	
	
	
	public SignupDTO() {
	System.out.println("Created "+this.getClass().getSimpleName());
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
		this.empID = empID;
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


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}




	@Override
	public String toString() {
		return "SignupDTO [id=" + id + ", empID=" + empID + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + "]";
	}


	
}
