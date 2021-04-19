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
import com.ss.uto.entity.BookingGuest;
/**
 * @author charvin
 *
 */
public class BookingGuestDao extends BaseDao<BookingGuest> {

	public BookingGuestDao(Connection conn) {
		super(conn);

	}


	public Integer addBookingGuest(BookingGuest bookGuest) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?, ?)",
				new Object[] { bookGuest.getBookingId().getId(), bookGuest.getEmail(), bookGuest.getPhone()});
	}

	public void updateBookingGuest(BookingGuest bookGuest) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_guest set booking_id = ?, contact_email = ?, contact_phone = ? where booking_id = ?", new Object[] {
				bookGuest.getBookingId().getId(), bookGuest.getEmail(), bookGuest.getPhone(),bookGuest.getBookingId().getId()});
	}

	public void deleteBookingGuest(BookingGuest bookGuest) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_guest where booking_id = ?", new Object[] { bookGuest.getBookingId().getId() });
	}

	public List<BookingGuest> getAllBookingGuest() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest");

	}



	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookGuests = new ArrayList<>();

		Booking booking = new Booking();

		while(rs.next()) {
			System.out.println(rs.getInt("booking_id") + " " + (rs.getString("contact_email")+" "+rs.getString("contact_phone")));
			booking.setId(9);

			BookingGuest bookGuest = new BookingGuest();

			bookGuest.setBookingId(booking);
			bookGuest.setEmail(rs.getString("contact_email"));
			bookGuest.setPhone(rs.getString("contact_phone"));

			bookGuests.add(bookGuest);



		}
		return bookGuests;
	}


	// for 1.1
	@Override
	public List<BookingGuest> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
