package com.xworkz.medi.service;

import java.util.List;

import com.xworkz.medi.entity.AppointmentEntity;
import com.xworkz.medi.entity.SignupEntity;

public interface SearchService {

	public List<AppointmentEntity> searchService(String fdate, String tdate, String empID);
}
