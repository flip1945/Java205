package guest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimeZone=UTC";
		String user = "bit";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(jdbcUrl, user, pw);
		
		return conn;
	}
}
