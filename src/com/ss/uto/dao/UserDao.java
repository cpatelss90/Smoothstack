/**
 * 
 */
package com.ss.uto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ss.uto.entity.User;
import com.ss.uto.entity.UserRole;

/**
 * @author charvin patel
 *
 */
public class UserDao extends BaseDao<User> {

	public UserDao(Connection conn) {
		super(conn);
	}


	public Integer addUser(User user) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getRoleId().getId(), user.getGivenName(), user.getFamilyName(), user.getUserName(), user.getEmail(), user.getPassword(), user.getPhone()});

	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?", new Object[] {
				user.getRoleId().getId(), user.getGivenName(),user.getFamilyName(), user.getUserName(),user.getEmail(),user.getPassword(), user.getPhone(), user.getId()});
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user where id = ?", new Object[] { user.getId() });
	}

	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user");

	}


	//-----------------------------------------------------------------------------------------------------------
	// Employee Specific Management
	public Integer addEmployee(User user) throws ClassNotFoundException, SQLException {

		return saveWithPK("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getRoleId().getId(), user.getGivenName(), user.getFamilyName(), user.getUserName(), user.getEmail(), user.getPassword(), user.getPhone()});

	}


	public void updateEmployee(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?", new Object[] {
				user.getRoleId().getId(), user.getGivenName(),user.getFamilyName(), user.getUserName(),user.getEmail(),user.getPassword(), user.getPhone(), user.getId()});
	}


	public void deleteEmployee(User user) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user where id = ?", new Object[] { user.getId() });
	}

	public List<User> getAllEmployees() throws ClassNotFoundException, SQLException {
		return read("select * from user,user_role where user.role_id = user_role.id && user_role.name = 'employee'");

	}


	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();

		UserRole userRole = new UserRole();
		
		System.out.println("ID  Role_ID   Given_Name    Family_Name     UserName           Email                Password              PhoneNum");


		while(rs.next()) {
			System.out.println(rs.getInt("id") + "     " + (rs.getString("role_id")+"        "+rs.getString("given_name")
			+"        "+rs.getString("family_name")+"          "+rs.getString("username")+"         "+rs.getString("email") + "    "+rs.getString("password") + "             "+rs.getString("phone")));

			userRole.setId(2);
			User user = new User();

			user.setId(rs.getInt("id"));
			user.setRoleId(userRole);
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));


			users.add(user);

		}
		return users;
	}


	// for 1.1
	@Override
	public List<User> extractDataFlightWithCity(ResultSet rs) throws ClassNotFoundException, SQLException {
		return null;
	}


}
