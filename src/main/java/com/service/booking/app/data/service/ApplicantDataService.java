package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.ApplicantData;

public interface ApplicantDataService {

	public void save(ApplicantData applicantData);
	public List<ApplicantData> findAll();
	public List<ApplicantData> findApplicantDataByBookingId(String applicantDataId);
	public ApplicantData getApplicantData(String applicantDataId);
}
