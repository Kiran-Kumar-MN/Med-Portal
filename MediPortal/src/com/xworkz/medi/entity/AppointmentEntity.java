package com.xworkz.medi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xworkz.medi.dto.AppointmentDTO;

@Entity
@Table(name = "appointment")
public class AppointmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462476132640229088L;

	@Id
	@Column(name = "App_ID")
	//@GenericGenerator(name = "ID", strategy = "increment")
	//@GeneratedValue(generator = "ID")
	private int id;

	@Column(name = "Emp_ID")
	private String emp_ID;

	@Column(name = "App_Date")
	private String date;

	@Column(name = "App_Time")
	private String time;

	@Column(name = "App_Reason")
	private String reason;
	
	@Transient
	private String emp_Email;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentDTO.class);

	public AppointmentEntity() {
		LOGGER.info("Created appointment Entity");
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
		return "AppointmentEntity [id=" + id + ", emp_ID=" + emp_ID + ", date=" + date + ", time=" + time + ", reason="
				+ reason + ", emp_Email=" + emp_Email + "]";
	}

}
