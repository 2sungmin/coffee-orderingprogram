package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        String connectionUrl =
                "jdbc:mysql://localhost:3306/cafe?"  // Update with your MySQL server details
        		 + "user=root&password=rlarlxo123@";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(connectionUrl);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}