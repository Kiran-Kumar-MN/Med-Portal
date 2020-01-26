package com.xworkz.medi.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
public class EmployeeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7362093554097002704L;
	
	@Id
	@Column(name = "Emp_ID")
	private String empID;
	
	@Column(name = "Emp_Name")
	private String emp_name;
	
	@Column(name = "Emp_email")
	private String emp_email;
	
	@Column(name = "Emp_BG")
	private String emp_BG;
	
	@Column(name = "Emp_Phone")
	private long emp_phno;
	
	@Column(name = "Emp_City")
	private String emp_city;

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_BG() {
		return emp_BG;
	}

	public void setEmp_BG(String emp_BG) {
		this.emp_BG = emp_BG;
	}

	public long getEmp_phno() {
		return emp_phno;
	}

	public void setEmp_phno(long emp_phno) {
		this.emp_phno = emp_phno;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empID=" + empID + ", emp_name=" + emp_name + ", emp_email=" + emp_email + ", emp_BG="
				+ emp_BG + ", emp_phno=" + emp_phno + ", emp_city=" + emp_city + "]";
	}
	
	
}
