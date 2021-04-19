package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.ss.uto.dao.SeatAvailabilityDao;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.SeatAvailability;
import com.ss.uto.service.ConnectionUtil;

public class SeatAvailibilityDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			SeatAvailability seat = new SeatAvailability();
			SeatAvailabilityDao seatAvailDao = new SeatAvailabilityDao(connection);

			Flight flight = new Flight();



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading seat availability


			List<SeatAvailability> seatList = seatAvailDao.getAllSeats();



			assertEquals(22, seatList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding seat availability

			flight.setId(3);


			seat.setFlightId(flight);
			seat.setFirstClass(10);
			seat.setBusinessClass(15);
			seat.setEconomyClass(30);

			seatAvailDao.addSeats(seat);


			List<SeatAvailability> seatListTwo = seatAvailDao.getAllSeats();



			assertEquals(23, seatListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting seat availability

			seatAvailDao.deleteSeat(seat);


			List<SeatAvailability> routeListThree = seatAvailDao.getAllSeats();


			assertEquals(23, routeListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
