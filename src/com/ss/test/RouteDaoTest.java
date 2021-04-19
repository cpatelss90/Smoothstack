package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import com.ss.uto.dao.RouteDao;
import com.ss.uto.entity.Route;
import com.ss.uto.service.ConnectionUtil;

public class RouteDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			Route route = new Route();
			RouteDao routeDao = new RouteDao(connection);



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading airport


			List<Route> routeList = routeDao.getAllRoutes();



			assertEquals(20, routeList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding airport
			route.setOriginAirport("ORD");
			route.setDesAirport("BOS");
			routeDao.addRoute(route);


			List<Route> routeListTwo = routeDao.getAllRoutes();



			assertEquals(21, routeListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting airport


			routeDao.deleteRoute(route);


			List<Route> routeListThree = routeDao.getAllRoutes();


			assertEquals(21, routeListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
