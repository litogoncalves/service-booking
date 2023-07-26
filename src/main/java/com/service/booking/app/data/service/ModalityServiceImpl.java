package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Modality;
import com.service.booking.app.repository.ModalityRepository;

@Service
@Transactional(readOnly = true)
public class ModalityServiceImpl implements ModalityService {
	@Autowired
	ModalityRepository repository;

	@Override
	public void save(Modality modality) {
		repository.save(modality);
		
	}

	@Override
	public List<Modality> findAll() {
		return repository.findModalityByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Modality getModality(Integer modalityId) {
		return repository.findByModalityId(modalityId);
	}

}
