/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Route;


/**
 * @author charvin
 *
 */
public class RouteDao extends BaseDao<Route> {


	public RouteDao(Connection conn) {
		super(conn);
	}

	public Integer addRoute(Route route) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)",
				new Object[] { route.getOriginAirport(), route.getDesAirport() });
	}


	public void updateRoute(Route route, String oriRoute, String desRoute) throws ClassNotFoundException, SQLException {

		if(oriRoute.equals("N/A")) {
			save("UPDATE route set destination_id = ? where id = ?", new Object[] {
					desRoute, route.getId() });
		}

		else if(desRoute.equals("N/A")) {
			save("UPDATE route set  origin_id = ? where id = ?", new Object[] {
					oriRoute, route.getId() });
		}
		else {
			save("UPDATE route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
					oriRoute, desRoute, route.getId() });
		}
	}

	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("DELETE FROM route where id = ?", new Object[] { route.getId() });
	}

	public List<Route> getAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from route");

	}

	// For 1.1
	public List<Route> getOriginRoutesWithCity() throws ClassNotFoundException, SQLException {
		return readOriginFlightWithCIty("select route.id,origin_id, airport.city from route, airport where route.origin_id = airport.iata_id");

	}

	// For 1.1
	public List<Route> getDestRoutesWithCity() throws ClassNotFoundException, SQLException {
		return readDestFlightWithCIty("select route.id, destination_id, city from route, airport where route.destination_id = airport.iata_id");

	}


	// For 1.1.1
	public List<Route> getFlightDetails(String routeId) throws ClassNotFoundException, SQLException {
		return readFlightDetail("select origin_id, destination_id, departure_time, first_class, bussiness_class, economy_class from route, flight, seats_availibility where route.id = ? AND flight.route_id = route.id AND seats_availibility.flight_id = flight.id", new Object[] {routeId});

	}



	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("origin_id")+" "+rs.getString("destination_id")));
			Route route = new Route();
			route.setId(rs.getInt("id"));
			route.setOriginAirport(rs.getString("origin_id"));  // see if this works or check RouteDao
			route.setDesAirport(rs.getString("destination_id"));
			routes.add(route);
		}

		return routes;
	}


	// for 1.1
	@Override
	public List<Route> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getString("origin_id")+" "+rs.getString("destination_id")+ " " +rs.getString("city"));
		}

		return routes;
	}

	// for 1.1
	public List<Route> readOriginFlightWithCIty(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractDataOriginFlightWithCity(rs);
	}


	// for 1.1
	public List<Route> readDestFlightWithCIty(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractDataDestFlightWithCity(rs);
	}

	// for 1.1.1
	public List<Route> readFlightDetail(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractFlightDetails(rs);

	}


	// for 1.1
	public List<Route> extractDataOriginFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getString("id")+ " "+rs.getString("origin_id")+" "+rs.getString("city"));
		}

		return routes;
	}

	// for 1.1
	public List<Route> extractDataDestFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getString("id")+ " "+rs.getString("destination_id")+ " " +rs.getString("city"));
		}

		return routes;
	}


	// for 1.1.1
	public List<Route> extractFlightDetails(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getString("origin_id")+ " "+rs.getString("destination_id")+ " " +rs.getString("departure_time")+ " "+rs.getString("first_class")+ " "+rs.getString("bussiness_class")+ " "+rs.getString("economy_class"));
		}

		return routes;
	}

}

