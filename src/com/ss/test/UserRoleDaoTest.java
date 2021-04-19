package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import com.ss.uto.dao.UserRoleDao;
import com.ss.uto.entity.UserRole;
import com.ss.uto.service.ConnectionUtil;

public class UserRoleDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			UserRole userRole = new UserRole();
			UserRoleDao userRoleDao = new UserRoleDao(connection);





			//------------------------------------------------------------------------------------------------------------------
			// Test for reading user role


			List<UserRole> roleList = userRoleDao.getAllUsers();



			assertEquals(3, roleList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding user role

			userRole.setUserRoleName("forTrialPurpose");



			userRoleDao.addUserRole(userRole);


			List<UserRole> roleListTwo = userRoleDao.getAllUsers();



			assertEquals(4, roleListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting user role


			userRoleDao.deleteUserRole(userRole);


			List<UserRole> airplaneListThree = userRoleDao.getAllUsers();


			assertEquals(4, airplaneListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
