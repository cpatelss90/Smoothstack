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
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Ticket;

/**
 * @author charvin patel
 *
 */
public class TicketDao extends BaseDao<Ticket> {

	public TicketDao(Connection conn) {
		super(conn);

	}


	public Integer addTicket(Ticket ticket) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO tickets (booking_id, ticket_type) VALUES (?, ?)",
				new Object[] { ticket.getBookingId().getId(), ticket.getTicketType()});

	}

	public void updateTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		save("UPDATE tickets set booking_id = ?, ticket_type = ? where id = ?", new Object[] {
				ticket.getBookingId().getId(), ticket.getTicketType(),ticket.getId()});
	}

	public void deleteTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		save("DELETE FROM tickets where id = ?", new Object[] { ticket.getId() });
	}

	public List<Ticket> getAllTickets() throws ClassNotFoundException, SQLException {
		return read("select * from tickets");

	}


	// for 1.2
	public void updateSpecificFlight(Flight flight) throws ClassNotFoundException, SQLException {


		save("UPDATE flight set route_id = ?, departure_time = ? where id = ?", new Object[] {
				flight.getRouteId().getId(),flight.getDepartTime(), flight.getId()});

	}

	@Override
	public List<Ticket> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Ticket> tickets = new ArrayList<>();

		Booking booking = new Booking();

		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("booking_id")+" "+rs.getString("ticket_type")));
			booking.setId(4);

			Ticket ticket = new Ticket();

			ticket.setId(rs.getInt("id"));
			ticket.setBookingId(booking);  // see if this works or check RouteDao
			ticket.setTicketType(rs.getString("ticket_type"));

			tickets.add(ticket);



		}
		return tickets;
	}


	// for 1.1
	@Override
	public List<Ticket> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
