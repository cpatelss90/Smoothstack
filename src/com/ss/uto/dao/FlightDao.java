/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;


/**
 * @author charvin
 *
 */
public class FlightDao extends BaseDao<Flight> {

	public FlightDao(Connection conn) {
		super(conn);
	}


	public Integer addFlight(Flight flight) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?, ?, ?, ?, ?)",
				new Object[] { flight.getRouteId().getId(), flight.getAirplaneId().getId(), flight.getDepartTime(), flight.getReservedSeats(), flight.getSeatPrice()});

	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("UPDATE flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", new Object[] {
				flight.getRouteId().getId(), flight.getAirplaneId().getId(),flight.getDepartTime(), flight.getReservedSeats(),flight.getSeatPrice(), flight.getId()});
	}

	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight where id = ?", new Object[] { flight.getId() });
	}

	public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException {

		return read("select * from flight");

	}


	// for 1.2
	public void updateSpecificFlight(Flight flight) throws ClassNotFoundException, SQLException {


		save("UPDATE flight set route_id = ?, departure_time = ? where id = ?", new Object[] {
				flight.getRouteId().getId(),flight.getDepartTime(), flight.getId()});

	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		Route routeId = new Route();
		Airplane airplaneId = new Airplane();


		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("route_id")+" "+rs.getString("airplane_id")
			+" "+rs.getString("departure_time")+" "+rs.getString("reserved_seats")+" "+rs.getString("seat_price")));

			routeId.setId(5);
			airplaneId.setId(2);

			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setRouteId(routeId);
			flight.setAirplaneId(airplaneId);
			flight.setDepartTime(rs.getString("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getInt("seat_price"));


			flights.add(flight);
		}
		return flights;
	}


	// for 1.1
	@Override
	public List<Flight> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}

}
