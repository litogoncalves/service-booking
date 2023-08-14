package com.service.booking.app.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "email_sending_report")
public class EmailSendingReport {
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
	private String id;
	@JoinColumn(name = "booking_id", nullable = false)
	@ManyToOne
	private Booking booking;
	@Column(name = "mail_to", nullable=false)
	private String to;
	@Column(name="mail_cc")
	private String cc;
	@Column(name="mail_bcc")
	private String bcc;
	@Column(name="mail_subject")
	private String subject;
	@Column(name="mail_body", length = 65535)
	private String body;
	@Column(name="mail_send_date_time")
	private String sendDateTime;
	@Column(name="mail_success")
	private boolean success;
	@Column(name="mail_status")
	private int status;
	@Column(name="mail_status_message")
	private String message;
	
	public EmailSendingReport() {
	}

	public EmailSendingReport(Booking booking, String to, String cc, String bcc, String subject, String body,
			String sendDateTime, boolean success, int status, String message) {
		this.booking = booking;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
		this.sendDateTime = sendDateTime;
		this.success = success;
		this.status = status;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSendDateTime() {
		return sendDateTime;
	}

	public void setSendDateTime(String sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
