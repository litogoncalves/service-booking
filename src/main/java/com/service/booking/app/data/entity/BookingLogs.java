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
@Table(name = "booking_logs")
public class BookingLogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="id")
	private String bookingLogsId;
	@Column(length=30, nullable = false)
	private String action;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date actionDate;
	@Column(length = 30, nullable = false)
	private String actionBy;
	@Column(nullable = false)
	private String bookingId;
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service service;
	@ManyToOne
	@JoinColumn(name = "service_fee_id", nullable = false)
	private ServiceFee serviceFee;
	@ManyToOne
	@JoinColumn(name = "modality_id", nullable = false)
	private Modality modality;
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateToSchedule;
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	@ManyToOne
	@JoinColumn(name = "doc_type_id")
	private Document documentType;
	@ManyToOne
	@JoinColumn(name = "identity_doc_id", nullable = false)
	private IdentityDocument identityDoc;
	@Column(length = 150, nullable = false)
	private String nameReq;
	@Column(length = 50, nullable = false)
	private String surnameReq;
	@Column(length = 150, nullable = false)
	private String emailReq;
	@Column(length = 9, nullable = false)
	private String contactoReq;
	
	public BookingLogs() {
		
	}
	
	public BookingLogs(String action, Date actionDate, String actionBy, String bookingId, Service service,
			ServiceFee serviceFee, Modality modality, Status status, Date dateToSchedule, Location location,
			Document documentType, IdentityDocument identityDoc, String nameReq, String surnameReq, String emailReq,
			String contactoReq) {
		this.action = action;
		this.actionDate = actionDate;
		this.actionBy = actionBy;
		this.bookingId = bookingId;
		this.service = service;
		this.serviceFee = serviceFee;
		this.modality = modality;
		this.status = status;
		this.dateToSchedule = dateToSchedule;
		this.location = location;
		this.documentType = documentType;
		this.identityDoc = identityDoc;
		this.nameReq = nameReq;
		this.surnameReq = surnameReq;
		this.emailReq = emailReq;
		this.contactoReq = contactoReq;
	}

	public String getBookingLogsId() {
		return bookingLogsId;
	}

	public void setBookingLogsId(String bookingLogsId) {
		this.bookingLogsId = bookingLogsId;
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

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public ServiceFee getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(ServiceFee serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Modality getModality() {
		return modality;
	}

	public void setModality(Modality modality) {
		this.modality = modality;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDateToSchedule() {
		return dateToSchedule;
	}

	public void setDateToSchedule(Date dateToSchedule) {
		this.dateToSchedule = dateToSchedule;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Document getDocumentType() {
		return documentType;
	}

	public void setDocumentType(Document documentType) {
		this.documentType = documentType;
	}

	public IdentityDocument getIdentityDoc() {
		return identityDoc;
	}

	public void setIdentityDoc(IdentityDocument identityDoc) {
		this.identityDoc = identityDoc;
	}

	public String getNameReq() {
		return nameReq;
	}

	public void setNameReq(String nameReq) {
		this.nameReq = nameReq;
	}

	public String getSurnameReq() {
		return surnameReq;
	}

	public void setSurnameReq(String surnameReq) {
		this.surnameReq = surnameReq;
	}

	public String getEmailReq() {
		return emailReq;
	}

	public void setEmailReq(String emailReq) {
		this.emailReq = emailReq;
	}

	public String getContactoReq() {
		return contactoReq;
	}

	public void setContactoReq(String contactoReq) {
		this.contactoReq = contactoReq;
	}
	
}
