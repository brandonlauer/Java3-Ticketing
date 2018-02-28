/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipd12.movieticketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 1796174
 */

class RecordNotFoundException extends SQLException {

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String msg) {
        super(msg);
    }

    public RecordNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

public class Database
{
	private static final String url = "jdbc:sqlserver://movietickets.database.windows.net:1433;databaseName=movieTickets;user=dbadmin;password=Root12345";
    Connection conn = null;

    public Database() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            // exception chaining
            throw new SQLException("Driver not found", ex);
        }
        conn = DriverManager.getConnection(url);
    }
	
	public void addUser(User user) throws SQLException
	{
		String sql = "INSERT INTO users (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql);) {
            statement.setString(1, user.firstName);
            statement.setString(2, user.lastName);
            statement.setString(3, user.email);
			statement.setString(4, user.password);
            statement.executeUpdate();
        }
	}
}
