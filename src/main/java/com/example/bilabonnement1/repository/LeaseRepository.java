package com.example.bilabonnement1.repository;

import com.example.bilabonnement1.model.DamageReport;
import com.example.bilabonnement1.model.Lease;
import com.example.bilabonnement1.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Lavet af Maria

@Repository
public class LeaseRepository {

    Connection connection;
    public LeaseRepository(){
        connection = ConnectionManager.connectionToDB();
    }

    public void createLease(Lease lease) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO lease(leaseID, clientID, carID, price) VALUES (?,?,?,?)");
        preparedStatement.setInt(1, lease.getLeaseID());
        preparedStatement.setInt(2, lease.getClientID());
        preparedStatement.setInt(3, lease.getCarID());
        preparedStatement.setInt(4, lease.getPrice());

        preparedStatement.executeUpdate();

    }


    public ArrayList<Lease> getAllLeases() {

        ArrayList<Lease> leases = new ArrayList<>();
        String query = "SELECT * FROM lease";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int leaseID = resultSet.getInt(1);
                int clientID = resultSet.getInt(2);
                int carID = resultSet.getInt(3);
                int price = resultSet.getInt(4);

                leases.add(new Lease(leaseID, clientID, carID, price));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return leases;
    }

    public Lease findLease(int leaseID) {
        Lease lease = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM lease WHERE leaseID = '" + leaseID + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int clientID = resultSet.getInt("clientID");
                int carID = resultSet.getInt("carID");
                int price = resultSet.getInt("price");
                lease = new Lease(leaseID, carID, clientID, price);
            }
        } catch (SQLException e) {
            System.out.println("Kunne ikke finde report" + e);
        }
        return lease;
    }

    public void deleteLease(int leaseID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lease WHERE leaseID=?");
            preparedStatement.setInt(1, leaseID);
             preparedStatement.executeUpdate();
            System.out.println("hej");

        } catch (SQLException e) {
            System.out.println("fejl" + e);

        }
    }
}
