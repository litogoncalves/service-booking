package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.GeneralData;
import com.service.booking.app.repository.GeneralDataRepository;

@Service
@Transactional(readOnly = true)
public class GeneralDataServiceImpl implements GeneralDataService {
	
	@Autowired
	GeneralDataRepository repository;

	@Override
	public void save(GeneralData generalData) {
		repository.save(generalData);
		
	}

	@Override
	public List<GeneralData> findAll() {
		return repository.findAll();
	}

	@Override
	public GeneralData getGeneralData(Integer generalDataId) {
		return repository.findByGeneralDataId(generalDataId);
	}

	@Override
	public List<GeneralData> findGeneralDataByCategory(String category) {
		return repository.findGeneralDataByCategoryAndStatus(category, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public GeneralData getGeneralDataByName(String name, String category) {
		return repository.findGeneralDataByNameAndStatus(name, category, Constants.STATUS_INACTIVE_CODE);
	}

}
