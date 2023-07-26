package com.service.booking.app.data.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.booking.app.constants.Labels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "identity_document")
public class IdentityDocument {

	@Id
	@Column(name = "identity_number", length = 15)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String identityNumber;
	@Column(nullable = false, length = 150)
	private String name;
	@Column(nullable = false, length = 50)
	private String surname;
	@Column(name ="issue_date", nullable = true)
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date issueDate;
	@Column(nullable = false)
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Date validate;
	@Column(name = "local_of_issue", nullable = false, length = 50)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String localOfIssue;
	@Column(name = "is_lifetime", nullable = false)
	private boolean islifetime;
	@ManyToOne
	@JoinColumn(name = "status")
	private Status status;
	@Column(length = 50, nullable = false)
	private String createdBy;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createdDate;
	@Column(nullable = true)
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date lastUpdateDate;
	@Column(length = 50, nullable = true)
	private String lastUpdateBy;
	@Column(length = 2, nullable = false)
	private int version;
	
	public IdentityDocument() {
		
	}

	public IdentityDocument(String name, String surname, Date issueDate, Date validate, String localOfIssue,
			boolean islifetime, Status status, String createdBy, Date createdDate, Date lastUpdateDate,
			String lastUpdateBy, int version) {
		this.name = name;
		this.surname = surname;
		this.issueDate = issueDate;
		this.validate = validate;
		this.localOfIssue = localOfIssue;
		this.islifetime = islifetime;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.version = version;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getValidate() {
		return validate;
	}

	public void setValidate(Date validate) {
		this.validate = validate;
	}

	public String getLocalOfIssue() {
		return localOfIssue;
	}

	public void setLocalOfIssue(String localOfIssue) {
		this.localOfIssue = localOfIssue;
	}

	public boolean isIslifetime() {
		return islifetime;
	}

	public void setIslifetime(boolean islifetime) {
		this.islifetime = islifetime;
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
