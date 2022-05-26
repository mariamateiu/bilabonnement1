package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.utility.ConnectionManager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class LeaseRepository {


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


    public ArrayList<Lease> getAllLeases() {
        Connection connection = cm.connectionToDB();

        ArrayList<Lease> leases = new ArrayList<>();
        String query = "SELECT * FROM lease";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int leaseID = resultSet.getInt(1);
                int clientID = resultSet.getInt(2);
                int carID = resultSet.getInt(3);
                int VIN = resultSet.getInt(4);
                int price = resultSet.getInt(5);

                leases.add(new Lease(leaseID, clientID, carID, VIN, price));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return leases;
    }

    public void deleteLease(int leaseID) {
        Connection connection = cm.connectionToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM semestereksamen.lease WHERE leaseID=leaseID");
            preparedStatement.setInt(1, leaseID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fejl" + e);

        }


    }
}
