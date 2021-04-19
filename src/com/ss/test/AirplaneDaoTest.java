package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import com.ss.uto.dao.AirplaneDao;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.AirplaneType;
import com.ss.uto.service.ConnectionUtil;

//Test
public class AirplaneDaoTest {


	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Airplane airplane = new Airplane();
			AirplaneDao airplaneDao = new AirplaneDao(connection);

			AirplaneType airplaneType = new AirplaneType();




			//------------------------------------------------------------------------------------------------------------------
			// Test for reading airplane


			List<Airplane> airplaneList = airplaneDao.getAllAirplane();



			assertEquals(5, airplaneList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding airplane

			airplaneType.setId(2);
			airplane.setAirplaneTypeId(airplaneType);


			airplaneDao.addAirplane(airplane);


			List<Airplane> airplaneListTwo = airplaneDao.getAllAirplane();



			assertEquals(6, airplaneListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting airplane


			airplaneDao.deleteAirplane(airplane);


			List<Airplane> airplaneListThree = airplaneDao.getAllAirplane();


			assertEquals(6, airplaneListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


}
