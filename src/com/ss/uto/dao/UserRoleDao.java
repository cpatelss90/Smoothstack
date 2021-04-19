/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.UserRole;

/**
 * @author charvin patel
 *
 */
public class UserRoleDao extends BaseDao<UserRole> {
	public UserRoleDao(Connection conn) {
		super(conn);
	}

	public Integer addUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		return saveWithPK("INSERT INTO user_role (name) VALUES (?)",
				new Object[] { userRole.getUserRoleName()});
	}

	public void updateUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("UPDATE user_role set name = ? where id = ?", new Object[] {
				userRole.getUserRoleName(), userRole.getId()});
	}

	public void deleteUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user_role where id = ?", new Object[] { userRole.getId() });
	}

	public List<UserRole> getAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user_role");

	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = new ArrayList<>();


		while(rs.next()) {
			System.out.println(rs.getInt("id") + " " + (rs.getString("name")));

			UserRole userRole = new UserRole();
			userRole.setUserRoleName(rs.getString("name"));
			userRoles.add(userRole);
		}

		return userRoles;
	}

	// for 1.1
	@Override
	public List<UserRole> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}


}
