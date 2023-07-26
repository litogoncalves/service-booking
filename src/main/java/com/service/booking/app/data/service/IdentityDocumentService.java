package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.IdentityDocument;

public interface IdentityDocumentService {
	
	public void save(IdentityDocument identityDoc);
	public List<IdentityDocument> findAll();
	public IdentityDocument getIdentityDocument(Integer identityDocId);
}
