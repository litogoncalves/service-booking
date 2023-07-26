package com.service.booking.app.data.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	private String bookingId;
	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false)
	private Service service;
	@ManyToOne
	@JoinColumn(name = "service_fee_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private ServiceFee serviceFee;
	@ManyToOne
	@JoinColumn(name = "modality_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Modality modality;
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;
	@Column(nullable = false)
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Date dateToSchedule;
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Location location;
	@ManyToOne
	@JoinColumn(name = "doc_type_id")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Document documentType;
	@ManyToOne
	@JoinColumn(name = "identity_doc_id", nullable = false)
	private IdentityDocument identityDoc;
	@Column(name = "name_req", length = 150, nullable = false)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String nameReq;
	@Column(name = "surname_req", length = 50, nullable = false)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String surnameReq;
	@Column(name ="birthdate_req", nullable = false)
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Date birthdateReq;
	@ManyToOne
	@JoinColumn(name = "country_of_birth_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Country countryOfBirthReq;
	@ManyToOne
	@JoinColumn(name = "nationality_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Nationality nationality;
	@ManyToOne
	@JoinColumn(name = "province_address_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Province provinceAddress;
	@ManyToOne
	@JoinColumn(name = "district_address_id")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private District districtAddress;
	@Column(name = "neighborhood_req", length = 140)
	private String neighborhoodReq;
	@Column(name = "reason_for_travel", length = 140)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String reasonForTravel;
	@Column(length = 140)
	private String note;
	@Column(name = "email_req", length = 150, nullable = true)
	@Email
	private String emailReq;
	@ManyToOne
	@JoinColumn(name ="country_code_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private CountryCode countryCode;
	@Column(name ="phone_number_req", length = 20, nullable = true)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private String phoneNumberReq;
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
	//@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date cancelledDate;
	@Column(length = 150, nullable = true)
	private String cancelledBy;
	@Column(length = 2, nullable = false)
	private int version;
	@Transient
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String idNumber;
	@Transient
	//@NotNull(message = Labels.REQUIRED_FIELD)
	private Date idValidate;
	@Transient
	private String viatlicioRadioGroup;
	@Transient
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String localOfIssue;
	@Transient
	private String isIDDocLifetime;
	
	public Booking() {
	}

	public Booking(Service service, @NotNull(message = "Campo obrigatório") ServiceFee serviceFee,
			@NotNull(message = "Campo obrigatório") Modality modality, Status status,
			@NotNull(message = "Campo obrigatório") Date dateToSchedule,
			@NotNull(message = "Campo obrigatório") Location location,
			@NotNull(message = "Campo obrigatório") Document documentType,
			@NotEmpty(message = "Campo obrigatório") IdentityDocument identityDoc,
			@NotEmpty(message = "Campo obrigatório") String nameReq,
			@NotEmpty(message = "Campo obrigatório") String surnameReq,
			@NotNull(message = "Campo obrigatório") Date birthdateReq,
			@NotNull(message = "Campo obrigatório") Country countryOfBirthReq,
			@NotNull(message = "Campo obrigatório") Nationality nationality,
			@NotNull(message = "Campo obrigatório") Province provinceAddress,
			@NotNull(message = "Campo obrigatório") District districtAddress, String neighborhoodReq,
			@NotEmpty(message = "Campo obrigatório") String reasonForTravel, String note, String emailReq,
			@NotNull(message = "Campo obrigatório") CountryCode countryCode,
			@NotNull(message = "Campo obrigatório") String phoneNumberReq, String createdBy, Date createdDate,
			Date lastUpdateDate, String lastUpdateBy, Date cancelledDate, String cancelledBy, int version,
			@NotEmpty(message = "Campo obrigatório") String idNumber,
			@NotNull(message = "Campo obrigatório") Date idValidate, String viatlicioRadioGroup,
			@NotEmpty(message = "Campo obrigatório") String localOfIssue) {
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
		this.birthdateReq = birthdateReq;
		this.countryOfBirthReq = countryOfBirthReq;
		this.nationality = nationality;
		this.provinceAddress = provinceAddress;
		this.districtAddress = districtAddress;
		this.neighborhoodReq = neighborhoodReq;
		this.reasonForTravel = reasonForTravel;
		this.note = note;
		this.emailReq = emailReq;
		this.countryCode = countryCode;
		this.phoneNumberReq = phoneNumberReq;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.cancelledDate = cancelledDate;
		this.cancelledBy = cancelledBy;
		this.version = version;
		this.idNumber = idNumber;
		this.idValidate = idValidate;
		this.viatlicioRadioGroup = viatlicioRadioGroup;
		this.localOfIssue = localOfIssue;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getIsIDDocLifetime() {
		return isIDDocLifetime;
	}

	public void setIsIDDocLifetime(String isIDDocLifetime) {
		this.isIDDocLifetime = isIDDocLifetime;
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

	public void setServiceFee(ServiceFee fee) {
		this.serviceFee = fee;
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

	public String getDateToScheduleFormated() {
		
		// Convert Date to LocalDate
        LocalDate localDate = dateToSchedule.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();


        // Create a DateTimeFormatter with the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the date using the formatter
        String formattedDate = localDate.format(formatter);
        
		return formattedDate;
	}
	
	public void setDateToSchedule(Date dateToSchedule) {
		this.dateToSchedule = dateToSchedule;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public Country getCountryOfBirthReq() {
		return countryOfBirthReq;
	}

	public void setCountryOfBirthReq(Country countryOfBirthReq) {
		this.countryOfBirthReq = countryOfBirthReq;
	}

	public Province getProvinceAddress() {
		return provinceAddress;
	}

	public void setProvinceAddress(Province provinceAddress) {
		this.provinceAddress = provinceAddress;
	}
	
	public District getDistrictAddress() {
		return districtAddress;
	}

	public void setDistrictAddress(District districtAddress) {
		this.districtAddress = districtAddress;
	}
	
	public String getNeighborhoodReq() {
		return neighborhoodReq;
	}

	public void setNeighborhoodReq(String neighborhoodReq) {
		this.neighborhoodReq = neighborhoodReq;
	}

	public String getReasonForTravel() {
		return reasonForTravel;
	}

	public void setReasonForTravel(String reasonForTravel) {
		this.reasonForTravel = reasonForTravel;
	}

	public String getEmailReq() {
		return emailReq;
	}

	public void setEmailReq(String emailReq) {
		this.emailReq = emailReq;
	}
	
	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumberReq() {
		return phoneNumberReq;
	}

	public void setPhoneNumberReq(String phoneNumberReq) {
		this.phoneNumberReq = phoneNumberReq;
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

	public Date getBirthdateReq() {
		return birthdateReq;
	}

	public void setBirthdateReq(Date birthdateReq) {
		this.birthdateReq = birthdateReq;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getIdValidate() {
		return idValidate;
	}

	public void setIdValidate(Date idValidate) {
		this.idValidate = idValidate;
	}

	public String getLocalOfIssue() {
		return localOfIssue;
	}

	public void setLocalOfIssue(String localOfIssue) {
		this.localOfIssue = localOfIssue;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public String getViatlicioRadioGroup() {
		return viatlicioRadioGroup;
	}

	public void setViatlicioRadioGroup(String viatlicioRadioGroup) {
		this.viatlicioRadioGroup = viatlicioRadioGroup;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", service=" + service + ", serviceFee=" + serviceFee + ", modality="
				+ modality + ", status=" + status + ", dateToSchedule=" + dateToSchedule + ", location=" + location
				+ ", documentType=" + documentType + ", identityDoc=" + identityDoc + ", nameReq=" + nameReq
				+ ", surnameReq=" + surnameReq + ", birthdateReq=" + birthdateReq + ", countryOfBirthReq="
				+ countryOfBirthReq + ", nationality=" + nationality + ", provinceAddress=" + provinceAddress
				+ ", districtAddress=" + districtAddress + ", neighborhoodReq=" + neighborhoodReq + ", reasonForTravel="
				+ reasonForTravel + ", note=" + note + ", emailReq=" + emailReq + ", countryCode=" + countryCode
				+ ", phoneNumberReq=" + phoneNumberReq + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateBy=" + lastUpdateBy + ", cancelledDate="
				+ cancelledDate + ", cancelledBy=" + cancelledBy + ", version=" + version + ", idNumber=" + idNumber
				+ ", idValidate=" + idValidate + ", viatlicioRadioGroup=" + viatlicioRadioGroup + ", localOfIssue="
				+ localOfIssue + ", isIDDocLifetime=" + isIDDocLifetime + "]";
	}
	
	
	
}
