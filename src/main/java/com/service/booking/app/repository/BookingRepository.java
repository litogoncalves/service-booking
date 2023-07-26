package com.service.booking.app.repository;

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
}
