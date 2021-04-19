package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.uto.dao.BookingGuestDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingGuest;
import com.ss.uto.service.ConnectionUtil;

public class BookingGuestTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			BookingGuest bookGuest = new BookingGuest();
			BookingGuestDao bookGuestDao = new BookingGuestDao(connection);

			Booking booking = new Booking();




			//------------------------------------------------------------------------------------------------------------------
			// Test for reading booking guest


			List<BookingGuest> guestList = bookGuestDao.getAllBookingGuest();



			assertEquals(8, guestList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding booking guest

			booking.setId(9);
			bookGuest.setBookingId(booking);
			bookGuest.setEmail("This is email");
			bookGuest.setPhone("434-456-3133");

			bookGuestDao.addBookingGuest(bookGuest);


			List<BookingGuest> guestListTwo = bookGuestDao.getAllBookingGuest();



			assertEquals(9, guestListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting booking guest


			bookGuestDao.deleteBookingGuest(bookGuest);


			List<BookingGuest> guestListThree = bookGuestDao.getAllBookingGuest();


			assertEquals(8, guestListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
