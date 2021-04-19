package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.uto.dao.BookingDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.service.ConnectionUtil;

public class BookingDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Booking booking = new Booking();
			BookingDao bookingDao = new BookingDao(connection);




			//------------------------------------------------------------------------------------------------------------------
			// Test for reading booking


			List<Booking> bookingList = bookingDao.getAllBookings();


			assertEquals(35, bookingList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding booking

			booking.setBookingActive(1);
			booking.setConfirmCode("XSDJHG55");

			bookingDao.addBooking(booking);


			List<Booking> bookingListTwo = bookingDao.getAllBookings();



			assertEquals(36, bookingListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting booking


			bookingDao.deleteBooking(booking);


			List<Booking> bookingListThree = bookingDao.getAllBookings();


			assertEquals(36, bookingListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
