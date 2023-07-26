package com.service.booking.app.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.IdentityDocument;
import com.service.booking.app.repository.IdentityDocumentRepository;

@Service
@Transactional
public class IdentityDocumentServiceImpl implements IdentityDocumentService{

	@Autowired
	IdentityDocumentRepository repository;
	@Override
	public void save(IdentityDocument identityDoc) {
		identityDoc.setCreatedDate(new Date());
		identityDoc.setVersion(1);
		
		repository.save(identityDoc);
	}

	@Override
	public List<IdentityDocument> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentityDocument getIdentityDocument(Integer identityDocId) {
		// TODO Auto-generated method stub
		return null;
	}

}
