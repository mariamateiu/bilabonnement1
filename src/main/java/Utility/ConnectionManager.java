package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;

    public Connection connectionToDB(){
        String url = "jdbc:mysql://localhost:3306/semestereksamen";
        String user = "root";
        String password = "ngv38Bdt";

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("we have a connection");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("somethings wrong with the connection");
        }
        return connection;

    }

}
