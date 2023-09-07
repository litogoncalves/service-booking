package com.service.booking.app.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.ApplicantData;
import com.service.booking.app.repository.ApplicantDataRepository;

@Service
@Transactional
public class ApplicantDataServiceImpl implements ApplicantDataService {

	@Autowired
	ApplicantDataRepository repository;
	
	@Override
	public void save(ApplicantData applicantData) {
		applicantData.setCreatedDate(new Date());
		applicantData.setVersion(1);
		
		repository.save(applicantData);		
	}

	@Override
	public List<ApplicantData> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ApplicantData> findApplicantDataByBookingId(String applicantDataId) {
		return repository.findApplicantDataByBookingId(applicantDataId, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public ApplicantData getApplicantData(String applicantDataId) {
		return repository.findApplicantDataById(applicantDataId);
	}

}
