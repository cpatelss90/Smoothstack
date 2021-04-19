package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.ss.uto.dao.BookingUserDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.User;
import com.ss.uto.service.ConnectionUtil;

public class BookingUserDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			BookingUser bookUser = new BookingUser();
			BookingUserDao bookUserDao = new BookingUserDao(connection);

			Booking booking = new Booking();
			User user =new User();




			//------------------------------------------------------------------------------------------------------------------
			// Test for reading booking user


			List<BookingUser> userList = bookUserDao.getAllBookingUser();



			assertEquals(3, userList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding booking user


			booking.setId(5);
			user.setId(5);
			bookUser.setBookingId(booking);
			bookUser.setUserId(user);


			bookUserDao.addBookingUser(bookUser);


			List<BookingUser> userListTwo = bookUserDao.getAllBookingUser();



			assertEquals(4, userListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting booking user


			bookUserDao.deleteBookingUser(bookUser);


			List<BookingUser> userListThree = bookUserDao.getAllBookingUser();


			assertEquals(3, userListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
