package com.example.demo.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.BookingDetails;
import com.example.demo.entity.GenerateSchedule;

import jakarta.transaction.Transactional;


@Repository
public interface BookingDetailsRepository extends CrudRepository<BookingDetails, Long>{

	@Query(value = "select * from booking_details b where b.pnr_number = ?1", nativeQuery = true)
	BookingDetails findBypnrNo(long pnrNo);
	
	@Modifying
    @Query(value = "UPDATE booking_details SET booking_status = 'Cancelled' WHERE pnr_number = ?1", nativeQuery = true)
    @Transactional
    void updateBypnrNo(long pnrNo);
	
	@Query(value = "select b.booking_status from booking_details b where b.pnr_number = ?1", nativeQuery = true)
	String booking_statusByPnrNo(long id);

	@Query(value = "select b.pnr_number from booking_details b", nativeQuery = true)
	List<Long> allPnrNo();
	
	@Query(value = "select * from booking_details b where b.user_id = ?1", nativeQuery = true)
	List<BookingDetails> Booking_details(String id);
	
	@Query(value = "select * from booking_details where pnr_number = ?1", nativeQuery = true)
	List<BookingDetails> cancellation(long id);
	
	@Query(value = "select b.train_number from booking_details b where b.pnr_number = ?1", nativeQuery = true)
	int traiNumberByPnrNo(long id);

	@Query(value = "select b.class from booking_details b where b.pnr_number = ?1", nativeQuery = true)
	String classByPnrNo(long id);

	@Query(value = "select b.passenger_no from booking_details b where b.pnr_number = ?1", nativeQuery = true)
	int passengerNoByPnrNo(long id);
	
	@Query(value = "select b.passenger_no from booking_details b where (b.train_number = ?1 and b.class = '2A' and b.booking_status = 'Booked' and b.travel_date = ?2)", nativeQuery = true)
	List<Integer> listOf2APassengerCount(int train_number, Date travel_Date);
	
	@Query(value = "select b.passenger_no from booking_details b where (b.train_number = ?1 and b.class = '3A' and b.booking_status = 'Booked' and b.travel_date = ?2)", nativeQuery = true)
	List<Integer> listOf3APassengerCount(int train_number, Date travel_Date);
	 
}
