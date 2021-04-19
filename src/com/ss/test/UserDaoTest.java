package com.ss.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import com.ss.uto.dao.UserDao;
import com.ss.uto.entity.User;
import com.ss.uto.entity.UserRole;
import com.ss.uto.service.ConnectionUtil;

public class UserDaoTest {

	@Test
	public void testCrud() {


		try {

			ConnectionUtil conUtil = new ConnectionUtil();
			Connection connection = conUtil.getConnection();

			User user = new User();
			UserDao userDao = new UserDao(connection);

			UserRole userRole = new UserRole();



			//------------------------------------------------------------------------------------------------------------------
			// Test for reading user


			List<User> userList = userDao.getAllEmployees();


			assertEquals(4, userList.size());


			//------------------------------------------------------------------------------------------------------------------
			// Test for adding user
			userRole.setId(2);

			user.setRoleId(userRole);
			user.setGivenName("Hoegnd");
			user.setFamilyName("Joerkk");
			user.setUserName("Tommy99");
			user.setEmail("tommy76@gmail.com");
			user.setPassword("Pasword is this");
			user.setPhone("734-455-1321");
			userDao.addEmployee(user);


			List<User> userListTwo = userDao.getAllEmployees();



			assertEquals(5, userListTwo.size());




			//------------------------------------------------------------------------------------------------------------------
			// Test for deleting user


			userDao.deleteEmployee(user);


			List<User> userListThree = userDao.getAllEmployees();


			assertEquals(5, userListThree.size());		   	    

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
