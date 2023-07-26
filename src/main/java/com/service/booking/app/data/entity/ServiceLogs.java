package com.service.booking.app.data.entity;

import java.math.BigDecimal;
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
@Table(name = "service_logs")
public class ServiceLogs {
	
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
	private Integer serviceId;
	@Column(length = 150, nullable = false)
	private String serviceName;
	@Column(length = 30, nullable = false)
	private String status;
	@Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
	private BigDecimal serviceFee;
	@Column(length = 2, nullable = false)
	private int version;
	
	public ServiceLogs() {
	}

	public ServiceLogs(String action, Date actionDate, String actionBy, Integer serviceId, String serviceName,
			String status, BigDecimal serviceFee, int version) {
		this.action = action;
		this.actionDate = actionDate;
		this.actionBy = actionBy;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.status = status;
		this.serviceFee = serviceFee;
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

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
