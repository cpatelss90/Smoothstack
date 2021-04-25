package com.ss.uto.service;

import java.sql.Connection;

import java.sql.SQLException;

/**
 * @author charvin patel
 *
 */
import com.ss.uto.dao.RouteDao;
import com.ss.uto.dao.SeatAvailabilityDao;
import com.ss.uto.entity.Route;
import com.ss.uto.entity.SeatAvailability;

public class EmployeeService {

	ConnectionUtil connUtil = new ConnectionUtil();



	//For 1.1
	public void getAllOriginFlightsWithCity() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDao routeDao = new RouteDao(conn);
			routeDao.getOriginRoutesWithCity();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//For 1.1
	public void getAllDestFlightsWithCity() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDao routeDao = new RouteDao(conn);
			routeDao.getDestRoutesWithCity();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//For 1.1.1
	public void getAllFlightDetail(String routeId) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDao routeDao = new RouteDao(conn);
			routeDao.getFlightDetails(routeId);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	// for 1.2
	public void updateRoute(Route route, String oriRoute, String desRoute) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDao routeDao = new RouteDao(conn);
			routeDao.updateRoute(route,oriRoute,desRoute);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//for 1.3
	public void updateSeats(String input, SeatAvailability seatAvail) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
			seatDao.updateSeats(input,seatAvail);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//For 1.3
	public void getSpecificSeat(String seatId, String input) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
			seatDao.getSpecificSeat(seatId, input);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	
	public String getSpecificSeatByClass(String seatId, String input) throws SQLException {
		Connection conn = null;
		String seats = "";
		try {
			conn = connUtil.getConnection();
			SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
			seats = seatDao.getSpecificSeatWithClass(seatId, input);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		return seats;
	}


	public void getAllSeat() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
			seatDao.getAllSeats();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}



}
