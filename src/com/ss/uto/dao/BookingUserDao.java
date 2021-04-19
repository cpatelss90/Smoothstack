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
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.User;

/**
 * @author charvin patel
 *
 */
public class BookingUserDao extends BaseDao<BookingUser> {

	public BookingUserDao(Connection conn) {
		super(conn);
	}


	public Integer addBookingUser(BookingUser bookUser) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)",
				new Object[] { bookUser.getBookingId().getId(), bookUser.getUserId().getId()});

	}

	public void updateBookingUser(BookingUser bookUser) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user set booking_id = ?, user_id = ? where booking_id = ?", new Object[] {
				bookUser.getBookingId().getId(), bookUser.getUserId().getId(),bookUser.getBookingId().getId()});
	}

	public void deleteBookingUser(BookingUser bookUser) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_user where booking_id = ?", new Object[] { bookUser.getBookingId().getId() });
	}

	public List<BookingUser> getAllBookingUser() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user");

	}


	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingUsers = new ArrayList<>();
		Booking booking = new Booking();
		User user = new User();

		while(rs.next()) {
			System.out.println(rs.getInt("booking_id") + " " + (rs.getString("user_id")));
			booking.setId(5);
			user.setId(5);

			BookingUser bookUser = new BookingUser();
			bookUser.setBookingId(booking);
			bookUser.setUserId(user);;
			bookingUsers.add(bookUser);

		}
		return bookingUsers;
	}


	// for 1.1
	@Override
	public List<BookingUser> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
