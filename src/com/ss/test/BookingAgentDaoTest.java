package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.uto.dao.BookingAgentDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.User;
import com.ss.uto.service.ConnectionUtil;

public class BookingAgentDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			BookingAgent bookAgent = new BookingAgent();
			BookingAgentDao bookAgentDao = new BookingAgentDao(connection);

			Booking booking = new Booking();
			User user =new User();




			//------------------------------------------------------------------------------------------------------------------
			// Test for reading booking agent


			List<BookingAgent> agentList = bookAgentDao.getAllBookingAgent();



			assertEquals(1, agentList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding booking agent


			booking.setId(5);
			user.setId(5);

			bookAgent.setBookingId(booking);
			bookAgent.setAgentId(user);


			bookAgentDao.addBookingAgent(bookAgent);


			List<BookingAgent> agentListTwo = bookAgentDao.getAllBookingAgent();



			assertEquals(2, agentListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting booking agent


			bookAgentDao.deleteBookingAgent(bookAgent);


			List<BookingAgent> agentListThree = bookAgentDao.getAllBookingAgent();


			assertEquals(1, agentListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
