package com.example.demo.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.BookingDetailsRepository;
import com.example.demo.Repository.GenerateScheduleRepository;
import com.example.demo.entity.BookingDetails;

@Service
public class BookingDetailsService {
	@Autowired
	BookingDetailsRepository bookingDetail;
	@Autowired
	GenerateScheduleRepository generateScheduleRepository;

	public Iterable<BookingDetails> getAllBookings() {
		return bookingDetail.findAll();
	}

	static long pnrNo = 1234567;
    int PNRNo=0;
	public void AddDetails(String s_station, String d_station, int train_no, String date, String class1, int passno, String user_id,double fare) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		BookingDetails booking = new BookingDetails(pnrNo + bookingDetail.count(), s_station, d_station, train_no,
				sqlDate, class1, passno,"Booked",user_id,fare);
		bookingDetail.save(booking);
	}

	public void CancelBooking(BookingDetails booking) {
		bookingDetail.delete(booking);
	}
	
	public int getPNRNo()
	{
		PNRNo=(int) (pnrNo + bookingDetail.count());
		return PNRNo;
	}

	// whan booking is cancelling it update booking status
		public String updateBooking(long pnrNo) {
			System.out.println("pnr : " + pnrNo);
			List<Long> allpnrNo = new ArrayList<Long>();
			getAllPnrNo().forEach(allpnrNo::add);
			for (int i = 0; i < allpnrNo.size(); i++) {
				Long curr = allpnrNo.get(i);

				System.out.println(curr);
			}
			if (allpnrNo.contains(pnrNo)) {
				if (getBooking_status(pnrNo).equalsIgnoreCase("Cancelled")) {
					System.out.println("Your booking already cancelled");
					return "Your booking already cancelled";
				} else {
					bookingDetail.updateBypnrNo(pnrNo);
					System.out.println("Your ticket has been cancelled");
					return "Your ticket has been cancelled";
				}
			} else {
				return "Wrong PNR Number";
			}
		}	
	public String getBooking_status(long id) {
		return bookingDetail.booking_statusByPnrNo(id);
	}

	public List<Long> getAllPnrNo() {
		List<Long> pnrNo = new ArrayList<>();
		bookingDetail.allPnrNo().forEach(pnrNo::add);
		return pnrNo;
	}
	public List<BookingDetails> AllBooking_details(String user_id){
		List<BookingDetails> booking = new ArrayList<>();
		bookingDetail.Booking_details(user_id).forEach(booking::add);
		System.out.println(user_id);
		return booking;
	}
	
	//for cancellation
	public List<BookingDetails> cancelation(long id){
		List<BookingDetails> booking = new ArrayList<>();
		bookingDetail.cancellation(id).forEach(booking::add);
		System.out.println(id);
		return booking;
	}
	
	// get coach type
		public String getClassType(long id) {
			return bookingDetail.classByPnrNo(id);
		}

		// get number of passenger
		public int getPassengerNo(long id) {
			return bookingDetail.passengerNoByPnrNo(id);
		}
		// get train number
		public int getTrainNo(long id) {
			return bookingDetail.traiNumberByPnrNo(id);
		}
		// whan cancelling booking increase SeatsAvailability
		public void increaseSeatsAvailability(long pnrNo) {
			if (getClassType(pnrNo).equals("2A")) {
				String Seats = generateScheduleRepository.get2ATotalSeats(getTrainNo(pnrNo));
				System.out.println("in string " + Seats);
//					int seatCount = Integer.parseInt(Seats) + getTrainNo(pnrNo);
				int seatCount = Integer.parseInt(Seats) + getPassengerNo(pnrNo);
				System.out.println("increase seat" + seatCount);
				generateScheduleRepository.update2ASeats(seatCount, getTrainNo(pnrNo));
			}
			if (getClassType(pnrNo).equals("3A")) {
				String Seats = generateScheduleRepository.get3ATotalSeats(getTrainNo(pnrNo));
				int seatcout = Integer.parseInt(Seats) + getPassengerNo(pnrNo);
				generateScheduleRepository.update3ASeats(seatcout, getTrainNo(pnrNo));
			}
		}
		public boolean checkpnrNo(long id) {
			if(bookingDetail.allPnrNo().contains(id)) {
				return true;
			}else {
				return false;
			}
		}
		
		public int A2PassengerCount(int train_number, Date travel_Date) {
			List<Integer> listPassCout = new ArrayList<>();
			bookingDetail.listOf2APassengerCount(train_number, travel_Date).forEach(listPassCout::add);
			int passCount =0 ;
			for(int i = 0; i< listPassCout.size(); i++) {
				passCount = passCount + listPassCout.get(i);
			}
			return passCount;
		}
		
		public int A3PassengerCount(int train_number, Date travel_Date) {
			List<Integer> listPassCout = new ArrayList<>();
			bookingDetail.listOf3APassengerCount(train_number, travel_Date).forEach(listPassCout::add);
			int passCount =0 ;
			for(int i = 0; i< listPassCout.size(); i++) {
				passCount = passCount + listPassCout.get(i);
			}
			return passCount;
		}
}
