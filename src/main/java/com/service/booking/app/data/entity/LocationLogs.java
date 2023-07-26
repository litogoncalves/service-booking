package com.service.booking.app.data.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_logs")
public class LocationLogs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length=30, nullable = false)
	private String action;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date actionDate;
	@Column(length = 30, nullable = false)
	private String actionBy;
	@Column(nullable = false)
	private int locationId;
	@Column(length = 150, nullable = false)
	private String locationName;
	@Column(length = 3, nullable = false)
	private int cityId;
	@Column(length = 30, nullable = false)
	private String status;
	@Column(length = 2, nullable = false)
	private int version;
	
	
	public LocationLogs() {
	}


	public LocationLogs(String action, Date actionDate, String actionBy, int locationId, String locationName,
			int cityId, String status, int version) {
		this.action = action;
		this.actionDate = actionDate;
		this.actionBy = actionBy;
		this.locationId = locationId;
		this.locationName = locationName;
		this.cityId = cityId;
		this.status = status;
		this.version = version;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public Date getActionDate() {
		return actionDate;
	}


	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}


	public String getActionBy() {
		return actionBy;
	}


	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
}
