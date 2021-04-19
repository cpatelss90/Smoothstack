/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Airport;


/**
 * @author charvin patel
 *
 */
public class AirportDao extends BaseDao<Airport> {

	public AirportDao(Connection conn) {
		super(conn);
	}


	public Integer addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO airport (iata_id, city) VALUES (?, ?)",
				new Object[] { airport.getAirportCode(), airport.getCityName()});
	}

	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("UPDATE airport set iata_id = ?, city = ? where iata_id = ?", new Object[] {
				airport.getAirportCode(), airport.getCityName(), airport.getAirportCode() });
	}

	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airport where iata_id = ?", new Object[] { airport.getAirportCode() });
	}

	public List<Airport> getAllAirports() throws ClassNotFoundException, SQLException {
		return read("select * from airport");
	}


	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		
		System.out.println("\n");
		System.out.println("ID    City");

		while(rs.next()) {
			
		
			
			System.out.println(rs.getString("iata_id")+"   "+rs.getString("city"));

			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("iata_id"));
			airport.setCityName(rs.getString("city"));
			airports.add(airport);
		}


		return airports;
	}


	// for 1.1
	@Override
	public List<Airport> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}


}
