package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.ss.uto.dao.PassengerDao;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.Passenger;
import com.ss.uto.service.ConnectionUtil;

public class PassengerDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Passenger passenger = new Passenger();
			PassengerDao passengerDao = new PassengerDao(connection);

			Booking booking = new Booking();



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading passenger


			List<Passenger> passengerList = passengerDao.getAllPassengers();


			assertEquals(19, passengerList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding passenger
			booking.setId(5);
			passenger.setBookingId(booking);
			passenger.setGivenName("Hond");
			passenger.setFamilyName("Jokk");
			passenger.setBirthDay("2005-04-21");
			passenger.setGender("male");
			passenger.setAddress("765 S Golvi rd, AZ 57432, USA");
			passengerDao.addPassenger(passenger);




			List<Passenger> passengerListTwo = passengerDao.getAllPassengers();



			assertEquals(20, passengerListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting passenger


			passengerDao.deletePassenger(passenger);


			List<Passenger> passengerListThree = passengerDao.getAllPassengers();


			assertEquals(20, passengerListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
