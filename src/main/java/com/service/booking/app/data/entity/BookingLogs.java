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
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_logs")
public class BookingLogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
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
	@Column(nullable = false)
	private Integer serviceId;
	@Column(nullable = false)
	private Integer status;
	@Column(nullable = false)
	private Integer doc_type_id_req;
	@Column(length = 30, nullable = false)
	private String document_req_number;
	@Column(length = 150, nullable = false)
	private String nameReq;
	@Column(length = 50, nullable = false)
	private String surnameReq;
	@Column(length = 150, nullable = false)
	private String emailReq;
	@Column(length = 9, nullable = false)
	private int contactoReq;
	
}
