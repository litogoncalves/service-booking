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
@Table(name = "province_logs")
public class ProvinceLogs {

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
	private int provinceId;
	@Column(length = 150, nullable = false)
	private String provinceName;
	@Column(length = 30, nullable = false)
	private String status;
	@Column(length = 3, nullable = true)
	private int version;
	
	
	public ProvinceLogs() {
	}


	public ProvinceLogs(String action, Date actionDate, String actionBy, int provinceId, String provinceName,
			String status, int version) {
		this.action = action;
		this.actionDate = actionDate;
		this.actionBy = actionBy;
		this.provinceId = provinceId;
		this.provinceName = provinceName;
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


	public int getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
