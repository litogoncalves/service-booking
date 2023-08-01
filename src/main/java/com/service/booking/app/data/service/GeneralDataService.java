package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.GeneralData;

public interface GeneralDataService {

	public void save(GeneralData generalData);
	public List<GeneralData> findAll();
	public GeneralData getGeneralData(Integer generalDataId);
	public List<GeneralData> findGeneralDataByCategory(String category);
	public GeneralData getGeneralDataByName(String name,String category);
}
