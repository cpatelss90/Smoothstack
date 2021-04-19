package com.ss.uto.dao;

/**
 * @author charvin patel
 *
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.Airplane;
import com.ss.uto.entity.AirplaneType;

public class AirplaneDao extends BaseDao<Airplane> {

	public AirplaneDao(Connection conn) {
		super(conn);
	}

	public Integer addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO airplane (type_id) VALUES (?)",
				new Object[] { airplane.getAirplaneTypeId().getId()});
	}

	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane set type_id = ? where id = ? ", new Object[] {
				airplane.getAirplaneTypeId(), airplane.getId() });
	}

	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane where id = ?", new Object[] { airplane.getId() });
	}

	public List<Airplane> getAllAirplane() throws ClassNotFoundException, SQLException {
		return read("select * from airplane");
	}


	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();

		AirplaneType airplaneType = new AirplaneType();


		while (rs.next()) {

			System.out.println(rs.getInt("id")+"  "+rs.getInt("type_id"));

			airplaneType.setId(2);

			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			airplane.setAirplaneTypeId(airplaneType);



			airplanes.add(airplane);
		}
		return airplanes;
	}

	// for 1.1
	@Override
	public List<Airplane> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}


}
