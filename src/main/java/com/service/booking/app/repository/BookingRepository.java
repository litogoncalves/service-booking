package com.service.booking.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String>{
	Booking findByBookingId(String bookingId);
	
	@Query("SELECT b FROM Booking b WHERE b.identityDoc.identityNumber = :idNumber")
	Booking findBookingByIdentityDocNumber(@Param("idNumber") String idNumber);
	
	@Query("SELECT b FROM Booking b WHERE b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Booking> findBookingByStatus(@Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.bookingId = :booking_id and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
    List<Booking> findBookingByIdAndSurnameAndContact(@Param("booking_id") String booking_id, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.bookingId = :booking_id and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
	Booking getBookingByIdAndSurnameAndContact(@Param("booking_id") String booking_id, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.identityDoc.identityNumber = :id_doc_number and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
    List<Booking> findByIDDocNumberAndSurnameAndContact(@Param("id_doc_number") String id_doc_number, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.identityDoc.identityNumber = :id_doc_number and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
	Booking getBookingByIDDocNumberAndSurnameAndContact(@Param("id_doc_number") String id_doc_number, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.identityDoc.identityNumber = :id_doc_number and b.service.serviceId = :serviceId and b.dateToSchedule > current_date() and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	Booking getBookingByIDDocNumberAndStatusAndDate(@Param("id_doc_number") String id_doc_number, @Param("serviceId") Integer serviceId, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.phoneNumberReq = :phoneNumber and b.dateToSchedule > current_date() and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Booking> findByPhoneNumberAndStatusAndDate(@Param("phoneNumber") String phoneNumber, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.passport.passportNumber = :passportNumber and b.service.serviceId = :serviceId and b.dateToSchedule > current_date() and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	Booking getBookingByPassportNumberAndStatusAndDate(@Param("passportNumber") String passportNumber, @Param("serviceId") Integer serviceId, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.passport.passportNumber = :passportNumber and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
    List<Booking> findByPassportNumberAndSurnameAndContact(@Param("passportNumber") String id_doc_number, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.passport.passportNumber = :passportNumber and surnameReq = :surname_req and (phoneNumberReq = :contact or emailReq = :contact) ")
	Booking getBookingByPassportNumberAndSurnameAndContact(@Param("passportNumber") String id_doc_number, @Param("surname_req") String surname_req, @Param("contact") String contact);
	
	@Query("SELECT b FROM Booking b WHERE b.dateToSchedule >= :dateFrom and b.dateToSchedule <= :dateTo and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Booking> findByDatesAndStatus(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo,@Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.dateToSchedule >= :dateFrom and b.dateToSchedule <= :dateTo and "
			+ "b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	List<Booking> findByFilters(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.dateToSchedule >= :dateFrom and b.dateToSchedule <= :dateTo "
			+ "and b.service.serviceId = :serviceId and b.location.locationId = :locationId and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	List<Booking> findByAllFilters(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("serviceId") int serviceId, @Param("locationId") int locationId, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.dateToSchedule >= :dateFrom and b.dateToSchedule <= :dateTo "
			+ "and b.service.serviceId = :serviceId and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	List<Booking> findByDocAndStatus(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("serviceId") int serviceId, @Param("statusCode") String statusCode);
	
	@Query("SELECT b FROM Booking b WHERE b.dateToSchedule >= :dateFrom and b.dateToSchedule <= :dateTo "
			+ "and b.location.locationId = :locationId and b.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	List<Booking> findByLocationAndStatus(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("locationId") int locationId, @Param("statusCode") String statusCode);
	
}
