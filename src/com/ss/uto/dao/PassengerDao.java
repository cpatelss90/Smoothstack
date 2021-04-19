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
import com.ss.uto.entity.Passenger;

/**
 * @author charvin patel
 *
 */
public class PassengerDao extends BaseDao<Passenger>{

	public PassengerDao(Connection conn) {
		super(conn);
	}


	public Integer addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?, ?, ?, ?, ?, ?)",
				new Object[] { passenger.getBookingId().getId(), passenger.getGivenName(), passenger.getFamilyName(), passenger.getBirthDay(), passenger.getGender(), passenger.getAddress()});

	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("UPDATE passenger set booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address = ? where id = ?", new Object[] {
				passenger.getBookingId().getId(), passenger.getGivenName(),passenger.getFamilyName(), passenger.getBirthDay(),passenger.getGender(),passenger.getAddress(), passenger.getId()});
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE FROM passenger where id = ?", new Object[] { passenger.getId() });
	}

	public List<Passenger> getAllPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger");

	}


	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		Booking booking = new Booking();

		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("booking_id")+" "+rs.getString("given_name")
			+" "+rs.getString("family_name")+" "+rs.getString("dob")+" "+rs.getString("gender") + " "+rs.getString("address")));
			booking.setId(5);

			Passenger passenger = new Passenger();

			passenger.setId(rs.getInt("id"));
			passenger.setBookingId(booking);
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setBirthDay(rs.getString("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));


			passengers.add(passenger);


		}

		return passengers;
	}


	// for 1.1
	@Override
	public List<Passenger> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
