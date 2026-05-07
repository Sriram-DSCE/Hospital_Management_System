package com.hms.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn;

	private static String getEnvOrDefault(String key, String defaultValue) {
		String value = System.getenv(key);
		return value == null || value.isBlank() ? defaultValue : value;
	}
	
	public static Connection getConn() {
		
		try {
			
			//step:1 for connection - load the driver class 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step:2- create a connection
			String host = getEnvOrDefault("DB_HOST", "gfj-ow.h.filess.io");
			String port = getEnvOrDefault("DB_PORT", "3306");
			String database = getEnvOrDefault("DB_NAME", "hospitals_tailahead");
			String username = getEnvOrDefault("DB_USER", "hospitals_tailahead");
			String password = getEnvOrDefault("DB_PASSWORD", "79d8e44786b25049b63dca1c01860199538347fa");
			String url = "jdbc:mysql://" + gfj-ow.h.filess.io + ":" + 3306 + "/" + hospitals_tailahead;
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return conn;
	}
}
