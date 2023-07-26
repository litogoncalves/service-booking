package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Document;

public interface DocumentService {
	
	public void save(Document document);
	public List<Document> findAll();
	public Document getDocument(Integer documentId);

}
