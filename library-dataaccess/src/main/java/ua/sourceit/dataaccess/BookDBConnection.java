package ua.sourceit.dataaccess;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BookDBConnection {

	private static Connection connection = null;
	
	private static Connection getConnection() throws SQLException {
			String url = "jdbc:mysql://127.0.0.1:3306/library";
			String user = "root";
			String password = "root";
			return DriverManager.getConnection(url, user, password);
		
	}

	// Singleton pattern
	public static synchronized Connection getInstance() throws IOException, SQLException {
		if (connection == null) {
			connection = getConnection();
		}
		return connection;
	}
	
}
