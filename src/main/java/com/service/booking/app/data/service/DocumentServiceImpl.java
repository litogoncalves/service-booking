package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Document;
import com.service.booking.app.repository.DocumentRepository;

@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService{
	@Autowired 
	private DocumentRepository repository;

	@Override
	public void save(Document document) {
		repository.save(document);
		
	}

	@Override
	public List<Document> findAll() {
		return repository.findDocumentsByCaregoryAndStatus(Constants.DOCUMENT_TYPE_CATEGORY, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Document getDocument(Integer documentId) {
		return repository.findByDocumentId(documentId);
	}

}
