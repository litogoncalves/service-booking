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
@Table(name = "modality")
public class Modality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer modalityId;
	@Column(length = 150, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String category;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
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
	@Column(length = 2, nullable = false)
	private int version;
	
	public Modality() {
	}

	public Modality(String name, Status status, String createdBy, Date createdDate, Date lastUpdateDate,
			String lastUpdateBy, int version) {
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.version = version;
	}
	
	public Integer getModalityId() {
		return modalityId;
	}

	public void setModalityId(Integer modalityId) {
		this.modalityId = modalityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
	
}
