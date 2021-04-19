/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.SeatAvailability;

/**
 * @author charvin
 *
 */
public class SeatAvailabilityDao extends BaseDao<SeatAvailability> {

	public SeatAvailabilityDao(Connection conn) {
		super(conn);

	}


	public Integer addSeats(SeatAvailability seat) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO seats_availibility (flight_id, first_class, bussiness_class, economy_class) VALUES (?, ?, ?, ?)",
				new Object[] { seat.getFlightId().getId(), seat.getFirstClass(), seat.getBusinessClass(), seat.getEconomyClass()});
	}

	public void updateSeats(String input, SeatAvailability seatAvail) throws ClassNotFoundException, SQLException {

		if(input.equals("1")){
			save("UPDATE seats_availibility set flight_id = ?, first_class = ? where id = ?", new Object[] {
					seatAvail.getFlightId().getId(), seatAvail.getFirstClass(), seatAvail.getId()});
		}

		else if(input.equals("2")){
			save("UPDATE seats_availibility set flight_id = ?, bussiness_class = ? where id = ?", new Object[] {
					seatAvail.getFlightId().getId(), seatAvail.getBusinessClass(), seatAvail.getId()});
		}

		else if(input.equals("3")){
			save("UPDATE seats_availibility set flight_id = ?, economy_class = ? where id = ?", new Object[] {
					seatAvail.getFlightId().getId(), seatAvail.getEconomyClass(), seatAvail.getId()});
		}
		else {
			save("UPDATE seats_availibility set flight_id = ?, first_class = ?, bussiness_class = ?, economy_class = ? where id = ?", new Object[] {
					seatAvail.getFlightId().getId(), seatAvail.getFirstClass(),seatAvail.getBusinessClass(), seatAvail.getEconomyClass(), seatAvail.getId()});
		}
	}

	public void deleteSeat(SeatAvailability seat) throws ClassNotFoundException, SQLException {
		save("DELETE FROM seats_availibility where id = ?", new Object[] { seat.getId() });
	}

	public List<SeatAvailability> getSpecificSeat(String seatsId, String input) throws ClassNotFoundException, SQLException {

		if(input.equals("1")){
			return readFirstClass("select seats_availibility.id,first_class from seats_availibility, flight where seats_availibility.id = ? AND flight.id = ?", new Object[] {seatsId,input});
		}
		else if(input.equals("2")) {
			return readBusinessClass("select seats_availibility.id,bussiness_class from seats_availibility, flight where seats_availibility.id = ? AND flight.id = ?", new Object[] {seatsId,input});
		}

		else if(input.equals("3")) {
			return readEconomyClass("select seats_availibility.id,economy_class from seats_availibility, flight where seats_availibility.id = ? AND flight.id = ?", new Object[] {seatsId,input});
		}
		else {
			return read("select * from seats_availibility");

		}

	}


	public List<SeatAvailability> getAllSeats() throws ClassNotFoundException, SQLException {

		return read("select * from seats_availibility"); 
	}


	@Override
	public List<SeatAvailability> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<SeatAvailability> seatsAvail = new ArrayList<>();
		Flight flight = new Flight();

		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("flight_id")+ " " + rs.getString("first_class")
			+ rs.getString("bussiness_class")
			+ rs.getString("economy_class"));

			flight.setId(3);


			SeatAvailability seat = new SeatAvailability();

			seat.setFlightId(flight);
			seat.setFirstClass(rs.getInt("first_class"));
			seat.setBusinessClass(rs.getInt("bussiness_class"));
			seat.setEconomyClass(rs.getInt("economy_class"));
			seatsAvail.add(seat);


		}
		return seatsAvail;
	}



	public List<SeatAvailability> extractSpecificData(String input, ResultSet rs) throws ClassNotFoundException, SQLException {
		List<SeatAvailability> seatsAvail = new ArrayList<>();

		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("route_id")+" "+rs.getString("airplane_id")
			+" "+rs.getString("departure_time")+" "+rs.getString("reserved_seats")+" "+rs.getString("seat_price")));
		}
		return seatsAvail;
	}


	// for 1.1
	@Override
	public List<SeatAvailability> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {

		return null;
	}


}
