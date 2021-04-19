package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.uto.dao.AirplaneTypeDao;
import com.ss.uto.entity.AirplaneType;
import com.ss.uto.service.ConnectionUtil;

public class AirplaneTypeDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();


			AirplaneType airplaneType = new AirplaneType();
			AirplaneTypeDao airplaneTypeDao = new AirplaneTypeDao(connection);



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading airplane type


			List<AirplaneType> airplaneTypeListTwo = airplaneTypeDao.getAllAirplaneType();



			assertEquals(8, airplaneTypeListTwo.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding airplane type

			airplaneType.setMaxCapacity(225);
			airplaneTypeDao.addAirplaneType(airplaneType);



			List<AirplaneType> airplaneTypeList = airplaneTypeDao.getAllAirplaneType();

			assertEquals(9, airplaneTypeList.size());



			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting  airplane type


			airplaneTypeDao.deleteAirplaneType(airplaneType);


			List<AirplaneType> airportListThree = airplaneTypeDao.getAllAirplaneType();

			assertEquals(9, airportListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
