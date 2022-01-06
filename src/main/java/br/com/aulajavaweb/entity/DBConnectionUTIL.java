package br.com.aulajavaweb.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUTIL {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521/orclpdb";
	private static String user = "HR";
	private static String password = "123";

	private static Connection connection = null;

	public static Connection openConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Connected");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("ERROR DBCONNECT 1");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("ERROR DBCONNECT 2");
			}
			return connection;
		}
	}

}
