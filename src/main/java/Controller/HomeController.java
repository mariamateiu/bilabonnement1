package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeController {

    private static Connection connection;
    public static Connection connectionToDB () {


        String url = "jdbc:mysql://localhost:3306/semestereksamen";
        String user = "root";
        String password = "N123naomi";

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
