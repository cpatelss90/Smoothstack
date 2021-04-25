/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ss.uto.entity.SeatAvailability;


/**
 * @author charvin patel
 *
 */
public abstract class BaseDao<T> {


	public static Connection conn = null;

	public BaseDao(Connection conn) {
		this.conn = conn;
	}

	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
	}

	public Integer saveWithPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();

		if (rs.next()) {
			return rs.getInt(1);
		}

		return null;
	}

	public List<SeatAvailability> readFirstClass(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractFirstClass(rs);
	}

	public List<SeatAvailability> readBusinessClass(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractBusinessClass(rs);
	}

	public List<SeatAvailability> readEconomyClass(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractEconomyClass(rs);
	}

	public String readFirst(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractFirst(rs);
	}

	public String readBusiness(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractBusiness(rs);
	}

	public String readEconomy(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractEconomy(rs);
	}



	public List<T> read(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	public Integer readByIdType(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractDataByTypeId(rs);
	}
	
	public String readByIdFlight(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractByFlightId(rs);
	}
	
	public Integer extractDataByTypeId(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<AirplaneType> airplaneTypes = new ArrayList<>();
		Integer cap = 0;


		//System.out.println("ID   Max_Capacity");
	
		while(rs.next()) {
			
			//System.out.println(rs.getString("id") + "     " + rs.getInt("max_capacity"));
			cap = rs.getInt("max_capacity");
			
			/*AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(rs.getInt("id"));
			airplaneType.getMaxCapacity();  // see if this works or check RouteDao
			airplaneTypes.add(airplaneType);*/
		}

		return cap;
	}
	
	public String extractByFlightId(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<SeatAvailability> seatsAvail = new ArrayList<>();
		String airplane = "";

		System.out.println("ID  airplaneID");
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "     " + (rs.getString("airplane_id")));
			airplane = rs.getString("airplane_id");
		}
		return airplane;
	}
	
	
	
	public String readById(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int count = 1;
		for (Object o : vals) {
			pstmt.setObject(count, o);
			count++;
		}
		ResultSet rs = pstmt.executeQuery();
		return extractById(rs);
	}
	
	public String extractById(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<SeatAvailability> seatsAvail = new ArrayList<>();
		String airplane = "";

		//System.out.println("ID  TypeID");
		while(rs.next()) {
			//System.out.println(rs.getInt("id") + "     " + (rs.getString("type_id")));
			airplane = rs.getString("type_id");
			//System.out.println("Here: " + airplane);
		}
		return airplane;
	}

	public List<SeatAvailability> extractFirstClass(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<SeatAvailability> seatsAvail = new ArrayList<>();

		System.out.println("ID  First_Class");
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "     " + (rs.getString("first_class")));
		}
		return seatsAvail;
	}

	public List<SeatAvailability> extractBusinessClass(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<SeatAvailability> seatsAvail = new ArrayList<>();

		System.out.println("ID  Business_Class");
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "     " + (rs.getString("bussiness_class")));
		}
		return seatsAvail;
	}

	public List<SeatAvailability> extractEconomyClass(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<SeatAvailability> seatsAvail = new ArrayList<>();

		System.out.println("ID  Economy_Class");

		while(rs.next()) {
			System.out.println(rs.getInt("id") + "     " + (rs.getString("economy_class")));
		}
		return seatsAvail;
	}


	public String extractFirst(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<SeatAvailability> seatsAvail = new ArrayList<>();

		String firstClassSeats = "";
		//System.out.println("ID  First_Class");
		while(rs.next()) {
			//System.out.println(rs.getInt("id")+ "       " + rs.getString("first_class"));
			firstClassSeats  = rs.getString("first_class");
		}
		return firstClassSeats;
		
	}

	public String extractBusiness(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<SeatAvailability> seatsAvail = new ArrayList<>();

		String businessClassSeats = "";
		//System.out.println("ID   Business_Class");
		while(rs.next()) {
			//System.out.println(rs.getInt("id") + "      " + rs.getString("bussiness_class"));
			businessClassSeats = rs.getString("bussiness_class");
		}
		return businessClassSeats;
	}

	public String extractEconomy(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<SeatAvailability> seatsAvail = new ArrayList<>();
		String economyClassSeats = "";
		//System.out.println("ID   Economy_Class");

		while(rs.next()) {
			//System.out.println(rs.getInt("id") + "       " +  rs.getString("economy_class"));
			economyClassSeats = rs.getString("economy_class");
		}
		return economyClassSeats;
	}



	public abstract List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;


	// for 1.1
	public List<T> readOriginFlightWithCIty(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractDataFlightWithCity(rs);
	}



	// for 1.1
	public abstract List<T> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException;
}



