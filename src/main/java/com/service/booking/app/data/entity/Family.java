package com.service.booking.app.data.entity;

import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "family")
public class Family {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
	private String id;
	@JoinColumn(name = "booking_id", nullable = false)
	@ManyToOne
	private Booking bookingId;
	@Column(name = "full_name", nullable = false, length=150)
	private String fullName;
	@ManyToOne
	@JoinColumn(name = "nationality_id", nullable = false)
	private Nationality nationalityId;
	@Column(length=100)
	private String relationship;
	@Column(length=150)
	private String address;
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
	@Column(length = 50, nullable = false)
	private String createdBy;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDate createdDate;
	@Column(nullable = true)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDate lastUpdateDate;
	@Column(length = 50, nullable = true)
	private String lastUpdateBy;
	@Column(length = 2, nullable = false)
	private int version;
	
	public Family() {
	}

	public Family(Booking bookingId, String fullName, Nationality nationalityId, String relationship, String address,
			Status status, String createdBy, LocalDate createdDate, LocalDate lastUpdateDate, String lastUpdateBy, int version) {
		this.bookingId = bookingId;
		this.fullName = fullName;
		this.nationalityId = nationalityId;
		this.relationship = relationship;
		this.address = address;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Nationality getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(Nationality nationalityId) {
		this.nationalityId = nationalityId;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
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
		return "Family [id=" + id + ", bookingId=" + bookingId + ", fullName=" + fullName + ", nationalityId="
				+ nationalityId + ", relationship=" + relationship + ", address=" + address + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", lastUpdateBy=" + lastUpdateBy + ", version=" + version + "]";
	}

	
}
