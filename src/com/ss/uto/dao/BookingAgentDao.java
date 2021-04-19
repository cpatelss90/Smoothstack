/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.User;

/**
 * @author charvin patel
 *
 */
public class BookingAgentDao extends BaseDao<BookingAgent> {

	public BookingAgentDao(Connection conn) {
		super(conn);

	}

	public Integer addBookingAgent(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)",
				new Object[] { bookAgent.getBookingId().getId(), bookAgent.getAgentId().getId()});
	}

	public void updateBookingAgent(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
		save("UPDATE airport set booking_id = ?, agent_id = ? where booking_id = ?", new Object[] {
				bookAgent.getBookingId().getId(), bookAgent.getAgentId().getId()});
	}

	public void deleteBookingAgent(BookingAgent bookAgent) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_agent where booking_id = ?", new Object[] { bookAgent.getBookingId().getId() });
	}

	public List<BookingAgent> getAllBookingAgent() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent");
	}


	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = new ArrayList<>();
		Booking booking = new Booking();
		User user = new User();

		while(rs.next()) {
			System.out.println(rs.getString("booking_id")+" "+rs.getString("agent_id"));

			booking.setId(5);
			user.setId(5);

			BookingAgent bookAgent = new BookingAgent();
			bookAgent.setBookingId(booking);
			bookAgent.setAgentId(user);

			bookingAgents.add(bookAgent);

		}


		return bookingAgents;
	}

	@Override
	public List<BookingAgent> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}




}
