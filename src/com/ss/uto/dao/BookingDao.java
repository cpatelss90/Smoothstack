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

/**
 * @author charvin patel
 *
 */
public class BookingDao extends BaseDao<Booking> {

	public BookingDao(Connection conn) {
		super(conn);
	}


	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
				new Object[] { booking.getBookingActive(), booking.getConfirmCode()});
	}

	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ?, confirmation_code = ? where id = ?", new Object[] {
				booking.getBookingActive(), booking.getConfirmCode(), booking.getId() });
	}

	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking where id = ?", new Object[] { booking.getId()});
	}

	public List<Booking> getAllBookings() throws ClassNotFoundException, SQLException {
		return read("select * from booking");
	}


	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		
		System.out.println("ID  Is_Active  Confirmation_Code");

		while(rs.next()) {
			System.out.println(rs.getString("id")+"     "+rs.getInt("is_active")+ "          " +rs.getString("confirmation_code"));
			Booking booking = new Booking();

			booking.setBookingActive(rs.getInt("is_active"));
			booking.setConfirmCode(rs.getString("confirmation_code"));
			bookings.add(booking);
		}



		return bookings;
	}


	// for 1.1
	@Override
	public List<Booking> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
