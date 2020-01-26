package com.xworkz.medi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "registration_details")
public class SignupEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "ID", strategy = "increment")
	@GeneratedValue(generator = "ID")
	private int id;

	@Column(name = "Emp_ID")
	private String empID;

	@Column(name = "Emp_email")
	private String email;

	@Column(name = "Emp_password")
	private String password;

	@Transient
	private String confirmpassword;

	
	public SignupEntity() {
		System.out.println("Signup Entity Created");
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
		return "SignupEntity [id=" + id + ", empID=" + empID + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + "]";
	}

}
