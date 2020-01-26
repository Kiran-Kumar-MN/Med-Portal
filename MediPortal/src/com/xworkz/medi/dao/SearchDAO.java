package com.xworkz.medi.dao;

import java.util.List;

import com.xworkz.medi.entity.AppointmentEntity;

public interface SearchDAO {

	public List<AppointmentEntity> searchDAO(String fdate, String tdate, String empID);
}
