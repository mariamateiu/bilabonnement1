package com.example.bilabonnement1.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Lavet af Naomi
public class ConnectionManager {
    private static Connection connection;
    public static Connection connectionToDB () {


        String url = "jdbc:mysql://@eu-cdbr-west-02.cleardb.net/heroku_26b638a260d4157?reconnect=true";
        String user = "bcfade98494c81";
        String password = "c4349e89";

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
