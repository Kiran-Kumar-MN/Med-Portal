package com.xworkz.medi.dto;

import java.io.Serializable;

import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Table(name = "appointment")
public class AppointmentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5261312558915884801L;
	private int id;
	private String emp_ID;
	private String date;
	private String time;
	private String reason;
	private String emp_Email;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(AppointmentDTO.class);
	
	public AppointmentDTO() {
	LOGGER.info("Appointment DTO created");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEmp_Email() {
		return emp_Email;
	}

	public void setEmp_Email(String emp_Email) {
		this.emp_Email = emp_Email;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [id=" + id + ", emp_ID=" + emp_ID + ", date=" + date + ", time=" + time + ", reason="
				+ reason + ", emp_Email=" + emp_Email + "]";
	}
	
	
	
}
