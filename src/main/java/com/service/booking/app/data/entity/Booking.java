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
	@ManyToOne
	@JoinColumn(name = "passport_id")
	private Passport passport;
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
	@Column(name = "city_address")
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String cityAddress;
	@Column(name = "neighborhood_req", length = 140)
	private String neighborhoodReq;
	@Column(name = "street_address")
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String streetAddress;
	@Column(name = "hotel_reservation")
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String hotelReservation;
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
	@Column(name = "single_name")
	private String singleName;
	@ManyToOne
	@JoinColumn(name ="gender_id")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private GeneralData gender;
	@ManyToOne
	@JoinColumn(name ="marital_status_id")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private GeneralData maritalStatus;
	@Column(length = 150)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String professionReq;
	@Column(length = 150)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String positionReq;
	@Column(length = 150)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String companyReq;
	@Column(name = "have_ever_been_to_moz")
	private boolean haveEverBeenToMoz;
	@Column(name = "have_been_resident_moz")
	private boolean haveBeenResidentMoz;
	@Column(name = "reason_for_leaving_moz")
	private String reasonForLeavingMoz;
	@Column(nullable = true, name="departure_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date departureDate;
	@Column(name = "companies_worked_for")
	private String companiesWorkedFor;
	@ManyToOne
	@JoinColumn(name = "length_of_stay_moz_id")
	private GeneralData lengthOfStayMoz;
	@Column(nullable = true, name="resident_departure_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date residentDepartureDate;
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
	@Transient
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String idNumber;
	@Transient
	//@NotNull(message = Labels.REQUIRED_FIELD)
	private Date idIssue;
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
	@Transient
	private Nationality passportNationality;
	
	public Booking() {
	}
	
	public Booking(Service service, @NotNull(message = "Campo obrigatório") ServiceFee serviceFee,
			@NotNull(message = "Campo obrigatório") Modality modality, Status status,
			@NotNull(message = "Campo obrigatório") Date dateToSchedule,
			@NotNull(message = "Campo obrigatório") Location location,
			@NotNull(message = "Campo obrigatório") Document documentType, IdentityDocument identityDoc,
			Passport passport, @NotEmpty(message = "Campo obrigatório") String nameReq,
			@NotEmpty(message = "Campo obrigatório") String surnameReq,
			@NotNull(message = "Campo obrigatório") Date birthdateReq,
			@NotNull(message = "Campo obrigatório") Country countryOfBirthReq,
			@NotNull(message = "Campo obrigatório") Nationality nationality,
			@NotNull(message = "Campo obrigatório") Province provinceAddress,
			@NotNull(message = "Campo obrigatório") District districtAddress, String cityAddress, String neighborhoodReq, 
			String streetAddress, String hotelReservation,
			@NotEmpty(message = "Campo obrigatório") String reasonForTravel, String note, @Email String emailReq,
			@NotNull(message = "Campo obrigatório") CountryCode countryCode,
			@NotNull(message = "Campo obrigatório") String phoneNumberReq, String singleName,
			@NotNull(message = "Campo obrigatório") GeneralData gender,
			@NotNull(message = "Campo obrigatório") GeneralData maritalStatus,
			@NotEmpty(message = "Campo obrigatório") String professionReq,
			@NotEmpty(message = "Campo obrigatório") String positionReq,
			@NotEmpty(message = "Campo obrigatório") String companyReq, boolean haveEverBeenToMoz,
			boolean haveBeenResidentMoz, String reasonForLeavingMoz, Date departureDate, String companiesWorkedFor,
			GeneralData lengthOfStayMoz, Date residentDepartureDate, String createdBy, Date createdDate, Date lastUpdateDate,
			String lastUpdateBy, Date cancelledDate, String cancelledBy, int version, String idNumber, Date idIssue,
			Date idValidate, String viatlicioRadioGroup, String localOfIssue, String isIDDocLifetime,
			Nationality passportNationality) {
		this.service = service;
		this.serviceFee = serviceFee;
		this.modality = modality;
		this.status = status;
		this.dateToSchedule = dateToSchedule;
		this.location = location;
		this.documentType = documentType;
		this.identityDoc = identityDoc;
		this.passport = passport;
		this.nameReq = nameReq;
		this.surnameReq = surnameReq;
		this.birthdateReq = birthdateReq;
		this.countryOfBirthReq = countryOfBirthReq;
		this.nationality = nationality;
		this.provinceAddress = provinceAddress;
		this.districtAddress = districtAddress;
		this.cityAddress = cityAddress;
		this.neighborhoodReq = neighborhoodReq;
		this.streetAddress = streetAddress;
		this.hotelReservation = hotelReservation;
		this.reasonForTravel = reasonForTravel;
		this.note = note;
		this.emailReq = emailReq;
		this.countryCode = countryCode;
		this.phoneNumberReq = phoneNumberReq;
		this.singleName = singleName;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.professionReq = professionReq;
		this.positionReq = positionReq;
		this.companyReq = companyReq;
		this.haveEverBeenToMoz = haveEverBeenToMoz;
		this.haveBeenResidentMoz = haveBeenResidentMoz;
		this.reasonForLeavingMoz = reasonForLeavingMoz;
		this.departureDate = departureDate;
		this.companiesWorkedFor = companiesWorkedFor;
		this.lengthOfStayMoz = lengthOfStayMoz;
		this.residentDepartureDate = residentDepartureDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
		this.cancelledDate = cancelledDate;
		this.cancelledBy = cancelledBy;
		this.version = version;
		this.idNumber = idNumber;
		this.idIssue = idIssue;
		this.idValidate = idValidate;
		this.viatlicioRadioGroup = viatlicioRadioGroup;
		this.localOfIssue = localOfIssue;
		this.isIDDocLifetime = isIDDocLifetime;
		this.passportNationality = passportNationality;
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
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getSingleName() {
		return singleName;
	}

	public void setSingleName(String singleName) {
		this.singleName = singleName;
	}

	public GeneralData getGender() {
		return gender;
	}

	public void setGender(GeneralData gender) {
		this.gender = gender;
	}

	public GeneralData getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(GeneralData maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Date getIdIssue() {
		return idIssue;
	}

	public void setIdIssue(Date idIssue) {
		this.idIssue = idIssue;
	}

	public Nationality getPassportNationality() {
		return passportNationality;
	}

	public void setPassportNationality(Nationality passportNationality) {
		this.passportNationality = passportNationality;
	}

	public String getProfessionReq() {
		return professionReq;
	}

	public void setProfessionReq(String professionReq) {
		this.professionReq = professionReq;
	}

	public String getPositionReq() {
		return positionReq;
	}

	public void setPositionReq(String positionReq) {
		this.positionReq = positionReq;
	}

	public String getCompanyReq() {
		return companyReq;
	}

	public void setCompanyReq(String companyReq) {
		this.companyReq = companyReq;
	}

	public boolean isHaveEverBeenToMoz() {
		return haveEverBeenToMoz;
	}

	public void setHaveEverBeenToMoz(boolean haveEverBeenToMoz) {
		this.haveEverBeenToMoz = haveEverBeenToMoz;
	}

	public boolean isHaveBeenResidentMoz() {
		return haveBeenResidentMoz;
	}

	public void setHaveBeenResidentMoz(boolean haveBeenResidentMoz) {
		this.haveBeenResidentMoz = haveBeenResidentMoz;
	}

	public String getReasonForLeavingMoz() {
		return reasonForLeavingMoz;
	}

	public void setReasonForLeavingMoz(String reasonForLeavingMoz) {
		this.reasonForLeavingMoz = reasonForLeavingMoz;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getCompaniesWorkedFor() {
		return companiesWorkedFor;
	}

	public void setCompaniesWorkedFor(String companiesWorkedFor) {
		this.companiesWorkedFor = companiesWorkedFor;
	}

	public GeneralData getLengthOfStayMoz() {
		return lengthOfStayMoz;
	}

	public void setLengthOfStayMoz(GeneralData lengthOfStayMoz) {
		this.lengthOfStayMoz = lengthOfStayMoz;
	}

	public Date getResidentDepartureDate() {
		return residentDepartureDate;
	}

	public void setResidentDepartureDate(Date residentDepartureDate) {
		this.residentDepartureDate = residentDepartureDate;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getHotelReservation() {
		return hotelReservation;
	}

	public void setHotelReservation(String hotelReservation) {
		this.hotelReservation = hotelReservation;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", service=" + service + ", serviceFee=" + serviceFee + ", modality="
				+ modality + ", status=" + status + ", dateToSchedule=" + dateToSchedule + ", location=" + location
				+ ", documentType=" + documentType + ", identityDoc=" + identityDoc + ", passport=" + passport
				+ ", nameReq=" + nameReq + ", surnameReq=" + surnameReq + ", birthdateReq=" + birthdateReq
				+ ", countryOfBirthReq=" + countryOfBirthReq + ", nationality=" + nationality + ", provinceAddress="
				+ provinceAddress + ", districtAddress=" + districtAddress + ", neighborhoodReq=" + neighborhoodReq
				+ ", reasonForTravel=" + reasonForTravel + ", note=" + note + ", emailReq=" + emailReq
				+ ", countryCode=" + countryCode + ", phoneNumberReq=" + phoneNumberReq + ", singleName=" + singleName
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", professionReq=" + professionReq
				+ ", positionReq=" + positionReq + ", companyReq=" + companyReq + ", haveEverBeenToMoz="
				+ haveEverBeenToMoz + ", haveBeenResidentMoz=" + haveBeenResidentMoz + ", reasonForLeavingMoz="
				+ reasonForLeavingMoz + ", departureDate=" + departureDate + ", companiesWorkedFor="
				+ companiesWorkedFor + ", lengthOfStayMoz=" + lengthOfStayMoz + ", residentDepartureDate="
				+ residentDepartureDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateBy=" + lastUpdateBy + ", cancelledDate="
				+ cancelledDate + ", cancelledBy=" + cancelledBy + ", version=" + version + ", idNumber=" + idNumber
				+ ", idIssue=" + idIssue + ", idValidate=" + idValidate + ", viatlicioRadioGroup=" + viatlicioRadioGroup
				+ ", localOfIssue=" + localOfIssue + ", isIDDocLifetime=" + isIDDocLifetime + ", passportNationality="
				+ passportNationality + "]";
	}

	
	
}
