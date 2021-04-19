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



	public List<T> read(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
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



