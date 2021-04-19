package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.ss.uto.dao.TicketDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.Ticket;
import com.ss.uto.service.ConnectionUtil;

public class TicketDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Ticket ticket = new Ticket();
			TicketDao ticketDao = new TicketDao(connection);

			Booking booking = new Booking();



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading ticket


			List<Ticket> ticketList = ticketDao.getAllTickets();



			assertEquals(26, ticketList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding ticket


			booking.setId(4);
			ticket.setBookingId(booking);
			ticket.setTicketType("economy");

			ticketDao.addTicket(ticket);


			List<Ticket> ticketListTwo = ticketDao.getAllTickets();



			assertEquals(27, ticketListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting ticket


			ticketDao.deleteTicket(ticket);


			List<Ticket> ticketListThree = ticketDao.getAllTickets();


			assertEquals(27, ticketListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
