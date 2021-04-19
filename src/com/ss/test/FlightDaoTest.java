package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.uto.dao.FlightDao;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Route;
import com.ss.uto.service.ConnectionUtil;

public class FlightDaoTest {


	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Flight flight = new Flight();
			FlightDao flightDao = new FlightDao(connection);

			Route route = new Route();
			Airplane airplane = new Airplane();



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading flight


			List<Flight> flightList = flightDao.getAllFlights();



			assertEquals(23, flightList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding flight

			route.setId(5);
			airplane.setId(2);

			flight.setRouteId(route);
			flight.setAirplaneId(airplane);
			flight.setDepartTime("2026-06-12 08:30:00");
			flight.setReservedSeats(12);
			flight.setSeatPrice(230.23);

			flightDao.addFlight(flight);


			List<Flight> flightListTwo = flightDao.getAllFlights();



			assertEquals(24, flightListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting flight


			flightDao.deleteFlight(flight);


			List<Flight> flightListThree = flightDao.getAllFlights();


			assertEquals(24, flightListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
