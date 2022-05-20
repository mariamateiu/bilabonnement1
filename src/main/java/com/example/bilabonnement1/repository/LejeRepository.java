package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LejeRepository {

    ConnectionManager cm = new ConnectionManager();



    public void createLeje(Lease lease) throws SQLException {

        Connection connection = cm.connectionToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO semestereksamen.lease(leaseID, clientID, carID, VIN, price) VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1, lease.getLeaseID());
        preparedStatement.setInt(2, lease.getClientID());
        preparedStatement.setInt(3, lease.getCarID());
        preparedStatement.setInt(4, lease.getVIN());
        preparedStatement.setInt(5, lease.getPrice());

        preparedStatement.executeUpdate();

    }
}
