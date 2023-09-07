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
@Table(name = "family_members")
public class FamilyMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking bookingId;
	@Column(name = "fathers_name")
	private String fathersName;
	@ManyToOne
	@JoinColumn(name = "fathers_nationality_id")
	private Nationality fathersNationality;
	@Column(name = "mothers_name")
	private String mothersName;
	@ManyToOne
	@JoinColumn(name = "mothers_nationality_id")
	private Nationality mothersNationality;
	@Column(name = "spouses_name")
	private String spousesName;
	@ManyToOne
	@JoinColumn(name = "spouses_nationality_id")
	private Nationality spousesNationality;
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
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
	@Column(nullable = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date cancelledDate;
	@Column(length = 150, nullable = true)
	private String cancelledBy;
	@Column(length = 2, nullable = false)
	private int version;
	
	public FamilyMembers() {
	}


	public FamilyMembers(Booking bookingId, String fathersName, Nationality fathersNationality, String mothersName,
			Nationality mothersNationality, String spousesName, Nationality spousesNationality, Status status,
			String createdBy, Date createdDate, Date lastUpdateDate, String lastUpdateBy, Date cancelledDate,
			String cancelledBy, int version) {
		this.bookingId = bookingId;
		this.fathersName = fathersName;
		this.fathersNationality = fathersNationality;
		this.mothersName = mothersName;
		this.mothersNationality = mothersNationality;
		this.spousesName = spousesName;
		this.spousesNationality = spousesNationality;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.cancelledDate = cancelledDate;
		this.cancelledBy = cancelledBy;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Booking getBookingId() {
		return bookingId;
	}

	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public Nationality getFathersNationality() {
		return fathersNationality;
	}

	public void setFathersNationality(Nationality fathersNationality) {
		this.fathersNationality = fathersNationality;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public Nationality getMothersNationality() {
		return mothersNationality;
	}

	public void setMothersNationality(Nationality mothersNationality) {
		this.mothersNationality = mothersNationality;
	}

	public String getSpousesName() {
		return spousesName;
	}

	public void setSpousesName(String spousesName) {
		this.spousesName = spousesName;
	}

	public Nationality getSpousesNationality() {
		return spousesNationality;
	}

	public void setSpousesNationality(Nationality spousesNationality) {
		this.spousesNationality = spousesNationality;
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


	public Date getCancelledDate() {
		return cancelledDate;
	}


	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
	}


	public String getCancelledBy() {
		return cancelledBy;
	}


	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
}
