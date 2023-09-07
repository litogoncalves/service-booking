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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message = Labels.REQUIRED_FIELD)
	@Future(message = Labels.SET_DATE_IN_THE_FUTURE)
	private LocalDate dateToSchedule;
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Location location;
	@ManyToOne
	@JoinColumn(name = "doc_type_id")
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Document documentType;
	@ManyToOne
	@JoinColumn(name = "identity_doc_id")
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	@NotNull(message = Labels.REQUIRED_FIELD)
	@Past(message = Labels.SET_BIRTHDATE_IN_THE_PAST)
	private LocalDate birthdateReq;
	@ManyToOne
	@JoinColumn(name = "country_of_birth_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Country countryOfBirthReq;
	@ManyToOne
	@JoinColumn(name = "nationality_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private Nationality nationality;
	@ManyToOne
	@JoinColumn(name = "other_nationality_id")
	private Nationality otherNationality;
	@Column(name = "place_of_birth", length = 100)
	private String placeOfBirth;
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
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String hotelReservation;
	@Column(name = "reason_for_travel", length = 140)
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String reasonForTravel;
	@Column(length = 140)
	private String note;
	@Column(name = "email_req", length = 150, nullable = true)
	@Email(message = Labels.VALID_EMAIL)
	private String emailReq;
	@ManyToOne
	@JoinColumn(name ="country_code_id", nullable = false)
	@NotNull(message = Labels.REQUIRED_FIELD)
	private CountryCode countryCode;
	@Column(name ="phone_number_req", length = 20, nullable = true)
	@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String phoneNumberReq;
	@Column(name = "single_name")
	private String singleName;
	@ManyToOne
	@JoinColumn(name ="gender_id")
	//@NotNull(message = Labels.REQUIRED_FIELD)
	private GeneralData gender;
	@ManyToOne
	@JoinColumn(name ="marital_status_id")
	//@NotNull(message = Labels.REQUIRED_FIELD)
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
	private String haveEverBeenToMoz;
	@Column(name = "have_been_resident_moz")
	private String haveBeenResidentMoz;
	@Column(name = "reason_for_leaving_moz")
	private String reasonForLeavingMoz;
	@Column(name = "entry_date")
	private LocalDate entryDate;
	@Column(nullable = true, name="departure_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date departureDate;
	@Column(name = "companies_worked_for")
	private String companiesWorkedFor;
	@ManyToOne
	@JoinColumn(name = "length_of_stay_moz_id")
	private GeneralData lengthOfStayMoz;
	@ManyToOne
	@JoinColumn(name = "length_of_additional_days_id")
	private GeneralData lengthOfAdditionalDays;
	@Column(nullable = true, name="resident_departure_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date residentDepartureDate;
	@Column(name= "visa_req")
	private String visaReq;
	@Column(name= "visa_issue_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDate visaIssueDate;
	@Column(name= "visa_validate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDate visaValidate;
	@Column(length = 50, nullable = false)
	private String createdBy;
	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date createdDate;
	@Column(nullable = true)
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
	private String idNumber;
	@Transient
	//@NotNull(message = Labels.REQUIRED_FIELD)
	private LocalDate idIssue;
	@Transient
	//@NotNull(message = Labels.REQUIRED_FIELD)
	private LocalDate idValidate;
	@Transient
	private String viatlicioRadioGroup;
	@Transient
	//@NotEmpty(message = Labels.REQUIRED_FIELD)
	private String localOfIssue;
	@Transient
	private String isIDDocLifetime;
	@Transient
	private Nationality passportNationality;
	@Transient
	private String familyName;
	@Transient
	private Nationality familyNationality;
	@Transient
	private String familyRelationship;
	@Transient
	private String familyAddress;
	@Transient
	private String fatherName;
	@Transient
	private String motherName;
	@Transient
	private Nationality fatherNationality;
	@Transient
	private Nationality motherNationaliy;
	@Transient
	private GeneralData academicLevel;
	@Transient
	private String employer;
	@Transient
	private String workPhoneNumber;
	
	public Booking() {
	}

	public Booking(String bookingId, Service service, @NotNull(message = "Campo obrigatório") ServiceFee serviceFee,
			@NotNull(message = "Campo obrigatório") Modality modality, Status status,
			@NotNull(message = "Campo obrigatório") @Future(message = "A data definida deve ser estar no futuro") LocalDate dateToSchedule,
			@NotNull(message = "Campo obrigatório") Location location,
			@NotNull(message = "Campo obrigatório") Document documentType, IdentityDocument identityDoc,
			Passport passport, @NotEmpty(message = "Campo obrigatório") String nameReq,
			@NotEmpty(message = "Campo obrigatório") String surnameReq,
			@NotNull(message = "Campo obrigatório") @Past(message = "A data de nascimento deve ser uma data passada") LocalDate birthdateReq,
			@NotNull(message = "Campo obrigatório") Country countryOfBirthReq,
			@NotNull(message = "Campo obrigatório") Nationality nationality, Nationality otherNationality,
			String placeOfBirth, @NotNull(message = "Campo obrigatório") Province provinceAddress,
			@NotNull(message = "Campo obrigatório") District districtAddress,
			@NotEmpty(message = "Campo obrigatório") String cityAddress, String neighborhoodReq,
			@NotEmpty(message = "Campo obrigatório") String streetAddress, String hotelReservation,
			String reasonForTravel, String note, @Email(message = "Forneça um e-mail válido") String emailReq,
			@NotNull(message = "Campo obrigatório") CountryCode countryCode,
			@NotEmpty(message = "Campo obrigatório") String phoneNumberReq, String singleName,
			@NotNull(message = "Campo obrigatório") GeneralData gender,
			@NotNull(message = "Campo obrigatório") GeneralData maritalStatus,
			@NotEmpty(message = "Campo obrigatório") String professionReq,
			@NotEmpty(message = "Campo obrigatório") String positionReq,
			@NotEmpty(message = "Campo obrigatório") String companyReq, String haveEverBeenToMoz,
			String haveBeenResidentMoz, String reasonForLeavingMoz, LocalDate entryDate, Date departureDate,
			String companiesWorkedFor, GeneralData lengthOfStayMoz, GeneralData lengthOfAdditionalDays,
			Date residentDepartureDate, String visaReq, LocalDate visaIssueDate, LocalDate visaValidate,
			String createdBy, Date createdDate, Date lastUpdateDate, String lastUpdateBy, Date cancelledDate,
			String cancelledBy, int version, String idNumber, LocalDate idIssue, LocalDate idValidate,
			String viatlicioRadioGroup, String localOfIssue, String isIDDocLifetime, Nationality passportNationality,
			String familyName, Nationality familyNationality, String familyRelationship, String familyAddress,
			String fatherName, String motherName, Nationality fatherNationality, Nationality motherNationaliy,
			GeneralData academicLevel, String employer, String workPhoneNumber) {
		this.bookingId = bookingId;
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
		this.otherNationality = otherNationality;
		this.placeOfBirth = placeOfBirth;
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
		this.entryDate = entryDate;
		this.departureDate = departureDate;
		this.companiesWorkedFor = companiesWorkedFor;
		this.lengthOfStayMoz = lengthOfStayMoz;
		this.lengthOfAdditionalDays = lengthOfAdditionalDays;
		this.residentDepartureDate = residentDepartureDate;
		this.visaReq = visaReq;
		this.visaIssueDate = visaIssueDate;
		this.visaValidate = visaValidate;
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
		this.familyName = familyName;
		this.familyNationality = familyNationality;
		this.familyRelationship = familyRelationship;
		this.familyAddress = familyAddress;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fatherNationality = fatherNationality;
		this.motherNationaliy = motherNationaliy;
		this.academicLevel = academicLevel;
		this.employer = employer;
		this.workPhoneNumber = workPhoneNumber;
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

	public LocalDate getDateToSchedule() {
		return dateToSchedule;
	}

	public String getDateToScheduleFormated() {
		
		// Convert Date to LocalDate
        //LocalDate localDate = dateToSchedule.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();


        // Create a DateTimeFormatter with the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the date using the formatter
        String formattedDate = dateToSchedule.format(formatter);
        
		return formattedDate;
	}
	
	public void setDateToSchedule(LocalDate dateToSchedule) {
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

	public LocalDate getBirthdateReq() {
		return birthdateReq;
	}

	public void setBirthdateReq(LocalDate birthdateReq) {
		this.birthdateReq = birthdateReq;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public LocalDate getIdValidate() {
		return idValidate;
	}

	public void setIdValidate(LocalDate idValidate) {
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

	public LocalDate getIdIssue() {
		return idIssue;
	}

	public void setIdIssue(LocalDate idIssue) {
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

	public String isHaveEverBeenToMoz() {
		return haveEverBeenToMoz;
	}

	public void setHaveEverBeenToMoz(String haveEverBeenToMoz) {
		this.haveEverBeenToMoz = haveEverBeenToMoz;
	}

	public String isHaveBeenResidentMoz() {
		return haveBeenResidentMoz;
	}

	public void setHaveBeenResidentMoz(String haveBeenResidentMoz) {
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

	public GeneralData getLengthOfAdditionalDays() {
		return lengthOfAdditionalDays;
	}

	public void setLengthOfAdditionalDays(GeneralData lengthOfAdditionalDays) {
		this.lengthOfAdditionalDays = lengthOfAdditionalDays;
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

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Nationality getFamilyNationality() {
		return familyNationality;
	}

	public void setFamilyNationality(Nationality familyNationality) {
		this.familyNationality = familyNationality;
	}

	public String getFamilyRelationship() {
		return familyRelationship;
	}

	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public Nationality getOtherNationality() {
		return otherNationality;
	}

	public void setOtherNationality(Nationality otherNationality) {
		this.otherNationality = otherNationality;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Nationality getFatherNationality() {
		return fatherNationality;
	}

	public void setFatherNationality(Nationality fatherNationality) {
		this.fatherNationality = fatherNationality;
	}

	public Nationality getMotherNationaliy() {
		return motherNationaliy;
	}

	public void setMotherNationaliy(Nationality motherNationaliy) {
		this.motherNationaliy = motherNationaliy;
	}

	public String getHaveEverBeenToMoz() {
		return haveEverBeenToMoz;
	}

	public String getHaveBeenResidentMoz() {
		return haveBeenResidentMoz;
	}

	public String getVisaReq() {
		return visaReq;
	}

	public void setVisaReq(String visa) {
		this.visaReq = visa;
	}

	public LocalDate getVisaIssueDate() {
		return visaIssueDate;
	}

	public void setVisaIssueDate(LocalDate visaIssueDate) {
		this.visaIssueDate = visaIssueDate;
	}

	public LocalDate getVisaValidate() {
		return visaValidate;
	}

	public void setVisaValidate(LocalDate visaValidate) {
		this.visaValidate = visaValidate;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public GeneralData getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(GeneralData academicLevel) {
		this.academicLevel = academicLevel;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", service=" + service + ", serviceFee=" + serviceFee + ", modality="
				+ modality + ", status=" + status + ", dateToSchedule=" + dateToSchedule + ", location=" + location
				+ ", documentType=" + documentType + ", identityDoc=" + identityDoc + ", passport=" + passport
				+ ", nameReq=" + nameReq + ", surnameReq=" + surnameReq + ", birthdateReq=" + birthdateReq
				+ ", countryOfBirthReq=" + countryOfBirthReq + ", nationality=" + nationality + ", provinceAddress="
				+ provinceAddress + ", districtAddress=" + districtAddress + ", cityAddress=" + cityAddress
				+ ", neighborhoodReq=" + neighborhoodReq + ", streetAddress=" + streetAddress + ", hotelReservation="
				+ hotelReservation + ", reasonForTravel=" + reasonForTravel + ", note=" + note + ", emailReq="
				+ emailReq + ", countryCode=" + countryCode + ", phoneNumberReq=" + phoneNumberReq + ", singleName="
				+ singleName + ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", professionReq="
				+ professionReq + ", positionReq=" + positionReq + ", companyReq=" + companyReq + ", haveEverBeenToMoz="
				+ haveEverBeenToMoz + ", haveBeenResidentMoz=" + haveBeenResidentMoz + ", reasonForLeavingMoz="
				+ reasonForLeavingMoz + ", departureDate=" + departureDate + ", companiesWorkedFor="
				+ companiesWorkedFor + ", lengthOfStayMoz=" + lengthOfStayMoz + ", residentDepartureDate="
				+ residentDepartureDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdateDate=" + lastUpdateDate + ", lastUpdateBy=" + lastUpdateBy + ", cancelledDate="
				+ cancelledDate + ", cancelledBy=" + cancelledBy + ", version=" + version + ", idNumber=" + idNumber
				+ ", idIssue=" + idIssue + ", idValidate=" + idValidate + ", viatlicioRadioGroup=" + viatlicioRadioGroup
				+ ", localOfIssue=" + localOfIssue + ", isIDDocLifetime=" + isIDDocLifetime + ", passportNationality="
				+ passportNationality + ", familyName=" + familyName + ", familyNationality=" + familyNationality
				+ ", familyRelationship=" + familyRelationship + ", familyAddress=" + familyAddress + "]";
	}
	
}
