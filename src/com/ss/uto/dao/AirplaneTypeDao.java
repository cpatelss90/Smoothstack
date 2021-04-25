/**
 * 
 */
package com.ss.uto.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.AirplaneType;
/**
 * @author charvin patel
 *
 */
public class AirplaneTypeDao extends BaseDao<AirplaneType>{

	public AirplaneTypeDao(Connection conn) {
		super(conn);
	}

	public Integer addAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO airplane_type (max_capacity) VALUES (?)",
				new Object[] { airplaneType.getMaxCapacity()});
	}

	public void updateAirplaneType(AirplaneType airplanType) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capacity = ? where id = ? ", new Object[] {
				airplanType.getMaxCapacity(), airplanType.getId() });
	}

	public void deleteAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane_type where id = ?", new Object[] { airplaneType.getId() });
	}

	public List<AirplaneType> getAllAirplaneType() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type");

	}
	
	public Integer getAllAirplaneTypeById(String id) throws ClassNotFoundException, SQLException {
		return readByIdType("select * from airplane_type where id = ?", new Object[] {id});

	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();


		System.out.println("ID   Max_Capacity");
	
		while(rs.next()) {
			
			System.out.println(rs.getString("id") + "     " + rs.getInt("max_capacity"));
			
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(rs.getInt("id"));
			airplaneType.getMaxCapacity();  // see if this works or check RouteDao
			airplaneTypes.add(airplaneType);
		}

		return airplaneTypes;
	}
	
	
	/*public Integer extractDataByTypeId(ResultSet rs) throws ClassNotFoundException, SQLException {
		//List<AirplaneType> airplaneTypes = new ArrayList<>();
		Integer cap = 0;


		System.out.println("ID   Max_Capacity");
	
		while(rs.next()) {
			
			System.out.println(rs.getString("id") + "     " + rs.getInt("max_capacity"));
			cap = rs.getInt("max_capacity");
			
			/*AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(rs.getInt("id"));
			airplaneType.getMaxCapacity();  // see if this works or check RouteDao
			airplaneTypes.add(airplaneType);*/
		//}

		//return cap;
	//}*/

	// for 1.1
	@Override
	public List<AirplaneType> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
