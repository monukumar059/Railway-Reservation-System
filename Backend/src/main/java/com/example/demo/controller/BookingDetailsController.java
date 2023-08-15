package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingDetails;
import com.example.demo.service.BookingDetailsService;

@RestController
public class BookingDetailsController {

	@Autowired
	BookingDetailsService bookDetails;

	@RequestMapping("/AllBooking")
	public Iterable<BookingDetails> getBookings() {
		return bookDetails.getAllBookings();
	}

	@RequestMapping("/Add/Bookings/{s_staion}/{d_station}/{train_no}/{date}/{class}/{passno}/{UserId}/{fare}")
	public String addDetails(@PathVariable("s_staion") String s_staion, @PathVariable("d_station") String d_station,
			@PathVariable("train_no") int train_no, @PathVariable("date") String date,
			@PathVariable("class") String class1, @PathVariable("passno") int passno,@PathVariable("UserId") String UserId
			,@PathVariable("fare") double fare) {
		bookDetails.AddDetails(s_staion, d_station, train_no, date, class1, passno,UserId, fare*passno);
		return "Added";
	}
	@RequestMapping(value = "/deleteBooking/{id}")
	public String deleteBooking(@PathVariable BookingDetails id) {
		bookDetails.CancelBooking(id);
		return "Your ticket has been deleted";
	}

	@RequestMapping(value = "/CancelBooking/{id}")
	public String cancelBooking(@PathVariable long id) {
		return bookDetails.updateBooking(id);
	}
		@RequestMapping(value = "/Get/PNR/No")
	public int LastPNRNo() {
		return bookDetails.getPNRNo();
	}
	
	@RequestMapping(value = "/Booking_History/{user_id}")
	public List<BookingDetails> AllBooking_details(@PathVariable("user_id") String user_id){
		System.out.println(user_id);
		return bookDetails.AllBooking_details(user_id);
	}
	
	//
	@RequestMapping(value = "/cancellation/{id}")
	public List<BookingDetails> cancellation(@PathVariable long id){
		System.out.println(id);
		return bookDetails.cancelation(id);
	}
	
	//for checking pnrNo present or not
		@RequestMapping(value = "checkingpnrNo/{id}")
		public boolean checkpnrNo(@PathVariable long id) {
			return bookDetails.checkpnrNo(id);
		}
}
