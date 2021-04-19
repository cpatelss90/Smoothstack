package com.ss.test;

import static org.junit.Assert.*;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;


import org.junit.Test;


import com.ss.uto.dao.AirportDao;

import com.ss.uto.entity.Airport;

import com.ss.uto.service.ConnectionUtil;


public class AirportDaoTest {


	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Airport airport = new Airport();
			AirportDao airportDao = new AirportDao(connection);



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading airport


			List<Airport> airportListTwo = airportDao.getAllAirports();



			assertEquals(22, airportListTwo.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding airport
			airport.setAirportCode("GGG");
			airport.setCityName("Gondal");
			airportDao.addAirport(airport);


			List<Airport> airportList = airportDao.getAllAirports();



			assertEquals(23, airportList.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting airport

			airportDao.deleteAirport(airport);


			List<Airport> airportListThree = airportDao.getAllAirports();


			assertEquals(22, airportListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}





}
