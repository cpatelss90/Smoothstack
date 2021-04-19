/**
 * 
 */
package com.ss.uto.service;
import java.sql.Connection;
import java.sql.SQLException;
import com.ss.uto.dao.AirplaneDao;
import com.ss.uto.dao.AirplaneTypeDao;
import com.ss.uto.dao.AirportDao;
import com.ss.uto.dao.BookingAgentDao;
import com.ss.uto.dao.BookingDao;
import com.ss.uto.dao.BookingGuestDao;
import com.ss.uto.dao.BookingUserDao;
import com.ss.uto.dao.FlightDao;
import com.ss.uto.dao.PassengerDao;
import com.ss.uto.dao.RouteDao;
import com.ss.uto.dao.SeatAvailabilityDao;
import com.ss.uto.dao.TicketDao;
import com.ss.uto.dao.UserDao;
import com.ss.uto.dao.UserRoleDao;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.Airport;
import com.ss.uto.entity.Booking;
import com.ss.uto.entity.BookingAgent;
import com.ss.uto.entity.BookingGuest;
import com.ss.uto.entity.BookingUser;
import com.ss.uto.entity.Flight;
import com.ss.uto.entity.Passenger;
import com.ss.uto.entity.SeatAvailability;
import com.ss.uto.entity.User;

/**
 * @author charvin
 *
 */
public class AdminService {
	ConnectionUtil connUtil = new ConnectionUtil();

	// Airport Management
	public void addAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDao airportDao = new AirportDao(conn);
			airportDao.addAirport(airport);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDao airportDao = new AirportDao(conn);
			airportDao.updateAirport(airport);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDao airportDao = new AirportDao(conn);
			airportDao.deleteAirport(airport);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllAirports() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDao airportDao = new AirportDao(conn);
			airportDao.getAllAirports();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//----------------------------------------------------------------------------------------------------	
	// Flight Management

	public void addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDao flightDao = new FlightDao(conn);
			flightDao.addFlight(flight);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDao flightDao = new FlightDao(conn);
			flightDao.updateFlight(flight);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	// for 1.2
	public void updateSpecificFlights(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDao flightDao = new FlightDao(conn);
			flightDao.updateSpecificFlight(flight);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDao flightDao = new FlightDao(conn);
			flightDao.deleteFlight(flight);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllFlights() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDao flightDao = new FlightDao(conn);
			flightDao.getAllFlights();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//--------------------------------------------------------------------
	// Seats Management


	public void deleteSeats(SeatAvailability seat) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			SeatAvailabilityDao seatDao = new SeatAvailabilityDao(conn);
			seatDao.deleteSeat(seat);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}




	public void getAllSeats() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDao airplaneTypeDao = new AirplaneTypeDao(conn);
			airplaneTypeDao.getAllAirplaneType();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//----------------------------------------------------------------------------------------------------	
	// Booking/Tickets Management

	public void addBookings(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDao bookingDao = new BookingDao(conn);
			bookingDao.addBooking(booking);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void updateBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDao bookingDao = new BookingDao(conn);
			bookingDao.updateBooking(booking);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void deleteBookings(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDao bookingDao = new BookingDao(conn);
			bookingDao.deleteBooking(booking);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllBookings() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDao bookingDao = new BookingDao(conn);
			bookingDao.getAllBookings();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	//----------------------------------------------------------------------------------------------------	
	// Passenger Management

	public void addPassengers(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDao passengerDao = new PassengerDao(conn);
			passengerDao.addPassenger(passenger);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDao passengerDao = new PassengerDao(conn);
			passengerDao.updatePassenger(passenger);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void deletePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDao passengerDao = new PassengerDao(conn);
			passengerDao.deletePassenger(passenger);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllPassengers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDao passengerDao = new PassengerDao(conn);
			passengerDao.getAllPassengers();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void addBookingGuest(BookingGuest bookGuest) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingGuestDao bookGuestDao = new BookingGuestDao(conn);
			bookGuestDao.addBookingGuest(bookGuest);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void addBookingAgent(BookingAgent bookAgent) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingAgentDao bookingAgentDao = new  BookingAgentDao(conn);
			bookingAgentDao.addBookingAgent(bookAgent);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void addBookingUser(BookingUser bookUser) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingUserDao bookingUserDao = new  BookingUserDao(conn);
			bookingUserDao.addBookingUser(bookUser);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}




	//----------------------------------------------------------------------------------------------------	
	// Employee Management

	public void addEmployee(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDao userDao = new UserDao(conn);
			userDao.addEmployee(user);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void updateEmployee(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDao userDao = new UserDao(conn);
			userDao.updateEmployee(user);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void deleteEmployee(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDao userDao = new UserDao(conn);
			userDao.deleteEmployee(user);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllEmployee() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDao userDao = new UserDao(conn);
			userDao.getAllEmployees();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}






	//-------------------------------------------------
	public void getAllRoutes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDao routeDao = new RouteDao(conn);
			routeDao.getAllRoutes();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void getAllAriplaneType() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDao airplaneTypeDao = new AirplaneTypeDao(conn);
			airplaneTypeDao.getAllAirplaneType();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void getAllUserRole() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserRoleDao userRoleDao = new UserRoleDao(conn);
			userRoleDao.getAllUsers();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void getAllUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDao userDao = new UserDao(conn);
			userDao.getAllUsers();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void getAllTickets() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			TicketDao ticketDao = new TicketDao(conn);
			ticketDao.getAllTickets();
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}

	public void addAirplane(Airplane airplane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDao airplaneDao = new AirplaneDao(conn);
			airplaneDao.addAirplane(airplane);
			airplaneDao.conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}




}
