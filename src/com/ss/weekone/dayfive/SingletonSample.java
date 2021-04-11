package com.ss.weekone.dayfive;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ss.weekone.dayfour.Singleton;

/**
 * @author Charvin Patel
 */



// Sample Class provided By trainer and I improved this class 
// by making it thread safe and efficient.
public class SingletonSample {
	private static Connection conn = null;
	private static volatile SingletonSample instance = null;

	private SingletonSample() {}

	public static SingletonSample getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new SingletonSample();
				}
			}
		}
		return instance;
	}


	public static void databaseQuery(BigDecimal input) {
		try {
			conn = DriverManager.getConnection("url of database");
			Statement st;
			st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select id from table");
			int x = 0;
			int bigDemialtoInt = input.intValue();
			while(rs.next()) {
				x = rs.getInt(1) * bigDemialtoInt;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
