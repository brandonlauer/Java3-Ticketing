/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipd12.movieticketing;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
