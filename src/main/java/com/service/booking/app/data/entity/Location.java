package com.service.booking.app.data.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer locationId;
	@Column(length = 150, nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;
	@Column(name = "max_lead_days", length = 7, nullable = false)
	private int maxLeadDays;
	@Column(name = "min_lead_days", length = 7, nullable = false)
	private int minLeadDays;
	@Column(length = 50, nullable = false)
	private String createdBy;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createdDate;
	@Column(nullable = true)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date lastUpdateDate;
	@Column(length = 50, nullable = true)
	private String lastUpdateBy;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
	@Column(length = 2, nullable = true)
	private int version;
	
	
	public Location() {
	}

	public Location(String name, Province province, int maxLeadDays, int minLeadDays, String createdBy, Date createdDate,
			Date lastUpdateDate, String lastUpdateBy, int version) {
		this.name = name;
		this.province = province;
		this.maxLeadDays = maxLeadDays;
		this.minLeadDays = minLeadDays;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.version = version;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getMaxLeadDays() {
		return maxLeadDays;
	}

	public void setMaxLeadDays(int maxLeadDays) {
		this.maxLeadDays = maxLeadDays;
	}

	public int getMinLeadDays() {
		return minLeadDays;
	}

	public void setMinLeadDays(int minLeadDays) {
		this.minLeadDays = minLeadDays;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", name=" + name + ", province=" + province + ", maxLeadDays="
				+ maxLeadDays + ", minLeadDays=" + minLeadDays + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateBy=" + lastUpdateBy + ", status="
				+ status + ", version=" + version + "]";
	}
	
	
}
