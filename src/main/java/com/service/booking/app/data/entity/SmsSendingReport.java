package com.service.booking.app.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sms_sending_report")
public class SmsSendingReport {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
	private String id;
	@JoinColumn(name = "booking_id", nullable = false)
	@ManyToOne
	private Booking booking;
	@Column(name = "send_to", nullable=false)
	private String sendTo;
	@Column(name="message_text", length = 320)
	private String messageText;
	@Column(name="send_date_time")
	private String sendDateTime;
	@Column(name="sms_success")
	private boolean success;
	@Column(name="sms_status")
	private int status;
	@Column(name="sms_status_message")
	private String message;
	@Column(name="usendit_response", length = 1500)
	private String usenditResponse;

	public SmsSendingReport() {
	}

	public SmsSendingReport(String id, Booking booking, String sendTo, String messageText, String sendDateTime,
			boolean success, int status, String message) {
		this.id = id;
		this.booking = booking;
		this.sendTo = sendTo;
		this.messageText = messageText;
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

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
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

	public String getUsenditResponse() {
		return usenditResponse;
	}

	public void setUsenditResponse(String usenditResponse) {
		this.usenditResponse = usenditResponse;
	}
	
}
