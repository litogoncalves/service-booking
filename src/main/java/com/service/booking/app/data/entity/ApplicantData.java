package com.service.booking.app.data.entity;

import java.time.LocalDate;
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
@Table
public class ApplicantData {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking bookingId;
	@ManyToOne
	@JoinColumn(name = "literary_abilities_id")
	private GeneralData academicLevel;
	private String profession;
	private String employer;
	private String employerAddress;
	private String workPhone;
	private LocalDate contractValidate;
	private String otherActivities;
	@Column(name = "have_been_resident_in_country")
	private boolean haveBeenResidentInCountry;
	@Column(name = "activity_performed")
	private String activityPerformed;
	private String investments;
	@Column(name = "have_been_arrested")
	private boolean haveBeenArrested;
	@Column(name = "nature_of_crime")
	private String natureOfCrime;
	@ManyToOne
	@JoinColumn(name = "country_where_was_arrested")
	private Country countryWhereWasArrested;
	@Column(name = "have_been_tried_in_court")
	private boolean haveBeenTriedInCourt;
	@Column(name = "trial_date")
	private LocalDate trialDate;
	@Column(name = "length_of_sentence")
	private int lengthOfSentence;
	@ManyToOne
	@JoinColumn(name = "country_of_last_residence")
	private Country countryOfLastResidence;
	@Column(name = "departure_date_country_last_residence")
	private LocalDate departureDateCountryLastResidence;
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
	
	public ApplicantData() {
	}

	public ApplicantData(String id, Booking bookingId, GeneralData academicLevel, String profession, String employer,
			String employerAddress, String workPhone, LocalDate contractValidate, String otherActivities,
			boolean haveBeenResidentInCountry, String activityPerformed, String investments, boolean haveBeenArrested,
			String natureOfCrime, Country countryWhereWasArrested, boolean haveBeenTriedInCourt, LocalDate trialDate,
			int lengthOfSentence, Country countryOfLastResidence, LocalDate departureDateCountryLastResidence,
			Status status, String createdBy, Date createdDate, Date lastUpdateDate, String lastUpdateBy,
			Date cancelledDate, String cancelledBy, int version) {
		this.id = id;
		this.bookingId = bookingId;
		this.academicLevel = academicLevel;
		this.profession = profession;
		this.employer = employer;
		this.employerAddress = employerAddress;
		this.workPhone = workPhone;
		this.contractValidate = contractValidate;
		this.otherActivities = otherActivities;
		this.haveBeenResidentInCountry = haveBeenResidentInCountry;
		this.activityPerformed = activityPerformed;
		this.investments = investments;
		this.haveBeenArrested = haveBeenArrested;
		this.natureOfCrime = natureOfCrime;
		this.countryWhereWasArrested = countryWhereWasArrested;
		this.haveBeenTriedInCourt = haveBeenTriedInCourt;
		this.trialDate = trialDate;
		this.lengthOfSentence = lengthOfSentence;
		this.countryOfLastResidence = countryOfLastResidence;
		this.departureDateCountryLastResidence = departureDateCountryLastResidence;
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

	public GeneralData getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(GeneralData academicLevel) {
		this.academicLevel = academicLevel;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmployerAddress() {
		return employerAddress;
	}

	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public LocalDate getContractValidate() {
		return contractValidate;
	}

	public void setContractValidate(LocalDate contractValidate) {
		this.contractValidate = contractValidate;
	}

	public String getOtherActivities() {
		return otherActivities;
	}

	public void setOtherActivities(String otherActivities) {
		this.otherActivities = otherActivities;
	}

	public boolean isHaveBeenResidentInCountry() {
		return haveBeenResidentInCountry;
	}

	public void setHaveBeenResidentInCountry(boolean haveBeenResidentInCountry) {
		this.haveBeenResidentInCountry = haveBeenResidentInCountry;
	}

	public String getActivityPerformed() {
		return activityPerformed;
	}

	public void setActivityPerformed(String activityPerformed) {
		this.activityPerformed = activityPerformed;
	}

	public String getInvestments() {
		return investments;
	}

	public void setInvestments(String investments) {
		this.investments = investments;
	}

	public boolean isHaveBeenArrested() {
		return haveBeenArrested;
	}

	public void setHaveBeenArrested(boolean haveBeenArrested) {
		this.haveBeenArrested = haveBeenArrested;
	}

	public String getNatureOfCrime() {
		return natureOfCrime;
	}

	public void setNatureOfCrime(String natureOfCrime) {
		this.natureOfCrime = natureOfCrime;
	}

	public Country getCountryWhereWasArrested() {
		return countryWhereWasArrested;
	}

	public void setCountryWhereWasArrested(Country countryWhereWasArrested) {
		this.countryWhereWasArrested = countryWhereWasArrested;
	}

	public boolean isHaveBeenTriedInCourt() {
		return haveBeenTriedInCourt;
	}

	public void setHaveBeenTriedInCourt(boolean haveBeenTriedInCourt) {
		this.haveBeenTriedInCourt = haveBeenTriedInCourt;
	}

	public LocalDate getTrialDate() {
		return trialDate;
	}

	public void setTrialDate(LocalDate trialDate) {
		this.trialDate = trialDate;
	}

	public int getLengthOfSentence() {
		return lengthOfSentence;
	}

	public void setLengthOfSentence(int lengthOfSentence) {
		this.lengthOfSentence = lengthOfSentence;
	}

	public Country getCountryOfLastResidence() {
		return countryOfLastResidence;
	}

	public void setCountryOfLastResidence(Country countryOfLastResidence) {
		this.countryOfLastResidence = countryOfLastResidence;
	}

	public LocalDate getDepartureDateCountryLastResidence() {
		return departureDateCountryLastResidence;
	}

	public void setDepartureDateCountryLastResidence(LocalDate departureDateCountryLastResidence) {
		this.departureDateCountryLastResidence = departureDateCountryLastResidence;
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
