package com.xworkz.medi.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "registration_details")
public class SigninDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5635298184860763904L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "ID",strategy = "increment")
	@GeneratedValue(generator ="ID")
	private int id;
	
	@Column(name = "Emp_ID")
	private String empID;
	
	@Column(name = "Emp_email")
	private String email;
	
	@Column(name = "Emp_password")
	private String password;

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

	@Override
	public String toString() {
		return "SigninDTO [id=" + id + ", empID=" + empID + ", email=" + email + ", password=" + password + "]";
	}
}
