/**
 * 
 */
package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Modality;

/**
 * @author elexrafael
 *
 */
public interface ModalityService {

	public void save(Modality modality);
	public List<Modality> findAll();
	public Modality getModality(Integer modalityId);
	public List<Modality> findModalityByCategory(String category);
	public List<Modality> findModalityVisaExtend();
}
